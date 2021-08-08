package hu.ulyssys.java.course.javaee.demo.rest;


import hu.ulyssys.java.course.javaee.demo.entity.Car;
import hu.ulyssys.java.course.javaee.demo.entity.Owner;
import hu.ulyssys.java.course.javaee.demo.entity.Plane;
import hu.ulyssys.java.course.javaee.demo.entity.Ship;
import hu.ulyssys.java.course.javaee.demo.rest.model.*;
import hu.ulyssys.java.course.javaee.demo.service.CarService;
import hu.ulyssys.java.course.javaee.demo.service.OwnerService;
import hu.ulyssys.java.course.javaee.demo.service.PlaneService;
import hu.ulyssys.java.course.javaee.demo.service.ShipService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/owner")
public class OwnerRestService {
    @Inject
    private OwnerService ownerService;

    @Inject
    private CarService carService;

    @Inject
    private PlaneService planeService;

    @Inject
    private ShipService shipService;

    @GET
    public Response findAll() {
        List<Owner> entityList = ownerService.getAll();
        List<OwnerModel> modelList = new ArrayList<>();
        entityList.forEach(owner -> {
            modelList.add(createModelByEntity(owner));
        });
        return Response.ok(modelList).build();
    }

    @GET
    @Path("data/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findVehiclesByOwnerId(@PathParam("id") Long id) {
        Owner owner = ownerService.findById(id);
        if(owner==null){
            Response.status(Response.Status.NOT_FOUND).build();
        }

        List<Car> listOfCars = carService.getAll();
        List<CarModel> cars = listOfCars.stream().filter(c -> c.getOwner().getId().equals(id)).map(this::createModelByEntityCar).collect(Collectors.toList());

        List<Plane> listOfPlanes = planeService.getAll();
        List<PlaneModel> planes = listOfPlanes.stream().filter(p -> p.getOwner().getId().equals(id)).map(this::createModelByEntityPlane).collect(Collectors.toList());

        List<Ship> listOfShips = shipService.getAll();
        List<ShipModel> ships = listOfShips.stream().filter(s -> s.getOwner().getId().equals(id)).map(this::createModelByEntityShip).collect(Collectors.toList());


        List<CoreRestModel> vehicles = new ArrayList<>();
        vehicles.addAll(cars);
        vehicles.addAll(planes);
        vehicles.addAll(ships);

        OwnerModel ownerModel = createModelByEntityAndVehicleList(owner, vehicles);
        return Response.ok(ownerModel).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(OwnerModel model) {
        Owner owner = new Owner();
        owner.setFirstName(model.getFirstName());
        owner.setLastName(model.getLastName());
        ownerService.add(owner);
        return Response.ok(createModelByEntity(owner)).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(OwnerModel model) {
        Owner owner = ownerService.findById(model.getId());
        if(owner==null){
            Response.status(Response.Status.NOT_FOUND).build();
        }
        owner.setFirstName(model.getFirstName());
        owner.setLastName(model.getLastName());
        ownerService.update(owner);
        return Response.ok(createModelByEntity(owner)).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        Owner owner = ownerService.findById(id);
        if (owner == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        ownerService.remove(owner);
        return Response.ok().build();
    }

    //automatizalni mapstruct
    public OwnerModel createModelByEntity(Owner entity){
        OwnerModel model = new OwnerModel();
        model.setId(entity.getId());
        model.setFirstName(entity.getFirstName());
        model.setLastName(entity.getLastName());
        return model;
    }

    //automatizalni mapstruct
    public OwnerModel createModelByEntityAndVehicleList(Owner entity, List<CoreRestModel> vehicles){
        OwnerModel model = new OwnerModel();
        model.setId(entity.getId());
        model.setFirstName(entity.getFirstName());
        model.setLastName(entity.getLastName());
        model.setVehicleList(vehicles);
        return model;
    }

    //automatizalni mapstruct
    public CarModel createModelByEntityCar(Car entity){
        CarModel model = new CarModel();
        model.setId(entity.getId());
        model.setManufacturer(entity.getManufacturer());
        model.setVehicleType(entity.getVehicleType());
        model.setOwnerID(entity.getOwner().getId());
        return model;
    }

    //automatizalni mapstruct
    public PlaneModel createModelByEntityPlane(Plane entity){
        PlaneModel model = new PlaneModel();
        model.setId(entity.getId());
        model.setManufacturer(entity.getManufacturer());
        model.setVehicleType(entity.getVehicleType());
        model.setOwnerID(entity.getOwner().getId());
        return model;
    }

    //automatizalni mapstruct
    public ShipModel createModelByEntityShip(Ship entity){
        ShipModel model = new ShipModel();
        model.setId(entity.getId());
        model.setManufacturer(entity.getManufacturer());
        model.setVehicleType(entity.getVehicleType());
        model.setOwnerID(entity.getOwner().getId());
        return model;
    }
}