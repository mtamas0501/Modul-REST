package hu.ulyssys.java.course.javaee.demo.entity;


import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractVehicle extends AbstractEntity implements VehicleTypeAware {

    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "type")
    private String type;

    @JoinColumn(name = "farmer_id")
    @ManyToOne
    private Owner owner;

    public AbstractVehicle() {
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
