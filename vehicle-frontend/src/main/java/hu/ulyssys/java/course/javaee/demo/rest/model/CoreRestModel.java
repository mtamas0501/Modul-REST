package hu.ulyssys.java.course.javaee.demo.rest.model;

import hu.ulyssys.java.course.javaee.demo.entity.VehicleType;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

public abstract class CoreRestModel {
    private Long id;
    @NotEmpty
    private String manufacturer;
    private String type;
    private VehicleType vehicleType;
    private Long ownerID;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(Long ownerID) {
        this.ownerID = ownerID;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}