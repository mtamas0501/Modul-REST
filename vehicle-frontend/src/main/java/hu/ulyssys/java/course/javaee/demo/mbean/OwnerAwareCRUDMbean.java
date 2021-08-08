package hu.ulyssys.java.course.javaee.demo.mbean;

import hu.ulyssys.java.course.javaee.demo.entity.AbstractVehicle;
import hu.ulyssys.java.course.javaee.demo.entity.Owner;
import hu.ulyssys.java.course.javaee.demo.service.CoreService;
import hu.ulyssys.java.course.javaee.demo.service.OwnerService;

import java.util.List;

public abstract class OwnerAwareCRUDMbean<T extends AbstractVehicle> extends CoreCRUDMbean<T> {
    private List<Owner> ownerList;

    public OwnerAwareCRUDMbean(CoreService<T> service, OwnerService ownerService) {
        super(service);
        ownerList = ownerService.getAll();
    }


    public List<Owner> getOwnerList() {
        return ownerList;
    }

    public void setFarmerList(List<Owner> farmerList) {
        this.ownerList = farmerList;
    }
}
