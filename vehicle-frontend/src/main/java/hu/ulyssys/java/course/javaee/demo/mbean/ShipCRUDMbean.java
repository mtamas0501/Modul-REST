package hu.ulyssys.java.course.javaee.demo.mbean;

import hu.ulyssys.java.course.javaee.demo.entity.Plane;
import hu.ulyssys.java.course.javaee.demo.entity.Ship;
import hu.ulyssys.java.course.javaee.demo.service.OwnerService;
import hu.ulyssys.java.course.javaee.demo.service.PlaneService;
import hu.ulyssys.java.course.javaee.demo.service.ShipService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class ShipCRUDMbean extends OwnerAwareCRUDMbean<Ship> implements Serializable {


    @Inject
    public ShipCRUDMbean(ShipService shipService, OwnerService ownerService) {
        super(shipService, ownerService);
    }

    @Override
    protected String dialogName() {
        return "shipDialog";
    }

    @Override
    protected Ship initNewEntity() {
        return new Ship();
    }
}

