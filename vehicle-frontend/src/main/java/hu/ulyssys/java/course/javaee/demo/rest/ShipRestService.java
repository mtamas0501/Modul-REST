package hu.ulyssys.java.course.javaee.demo.rest;

import hu.ulyssys.java.course.javaee.demo.entity.Ship;
import hu.ulyssys.java.course.javaee.demo.rest.model.ShipModel;

import javax.ws.rs.Path;

@Path("/ship")
public class ShipRestService extends CoreRestService<Ship, ShipModel> {

    @Override
    protected Ship initNewEntity() {
        return new Ship();
    }

    @Override
    protected ShipModel initNewModel() {
        return new ShipModel();
    }
}
