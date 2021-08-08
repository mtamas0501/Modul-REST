package hu.ulyssys.java.course.javaee.demo.rest;


import hu.ulyssys.java.course.javaee.demo.entity.Car;
import hu.ulyssys.java.course.javaee.demo.rest.model.CarModel;


import javax.ws.rs.Path;

@Path("/car")
public class CarRestService extends CoreRestService<Car, CarModel>{
    @Override
    protected Car initNewEntity() {
        return new Car();
    }

    @Override
    protected CarModel initNewModel() {
        return new CarModel();
    }
}
