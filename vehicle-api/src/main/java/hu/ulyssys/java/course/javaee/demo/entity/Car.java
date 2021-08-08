package hu.ulyssys.java.course.javaee.demo.entity;

import javax.persistence.*;

@Entity
@Table
public class Car extends AbstractVehicle {

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.CAR;
    }

}
