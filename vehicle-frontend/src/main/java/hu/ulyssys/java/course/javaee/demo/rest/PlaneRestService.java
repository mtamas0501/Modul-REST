package hu.ulyssys.java.course.javaee.demo.rest;

import hu.ulyssys.java.course.javaee.demo.entity.Plane;
import hu.ulyssys.java.course.javaee.demo.rest.model.PlaneModel;

import javax.ws.rs.Path;

@Path("/plane")
public class PlaneRestService extends CoreRestService<Plane, PlaneModel> {

    @Override
    protected Plane initNewEntity() {
        return new Plane();
    }

    @Override
    protected PlaneModel initNewModel() {
        return new PlaneModel();
    }
}
