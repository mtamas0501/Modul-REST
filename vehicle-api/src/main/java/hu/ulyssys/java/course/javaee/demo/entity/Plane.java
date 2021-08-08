package hu.ulyssys.java.course.javaee.demo.entity;

import javax.persistence.*;

@Entity
@Table
public class Plane extends AbstractVehicle {

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.PLANE;
    }


}
