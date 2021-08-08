package hu.ulyssys.java.course.javaee.demo.rest.model;


import java.util.List;

public class OwnerModel extends CoreRestModel {
    private Long id;
    private String firstName;
    private String lastName;
    private List<CoreRestModel> vehicleList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<CoreRestModel> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<CoreRestModel> vehicleList) {
        this.vehicleList = vehicleList;
    }
}
