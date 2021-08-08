package hu.ulyssys.java.course.javaee.demo.mbean;

import hu.ulyssys.java.course.javaee.demo.entity.Plane;
import hu.ulyssys.java.course.javaee.demo.service.OwnerService;
import hu.ulyssys.java.course.javaee.demo.service.PlaneService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class PlaneCRUDMbean extends OwnerAwareCRUDMbean<Plane> implements Serializable {


    @Inject
    public PlaneCRUDMbean(PlaneService planeService, OwnerService ownerService) {
        super(planeService, ownerService);
    }

    @Override
    protected String dialogName() {
        return "planeDialog";
    }

    @Override
    protected Plane initNewEntity() {
        return new Plane();
    }
}

