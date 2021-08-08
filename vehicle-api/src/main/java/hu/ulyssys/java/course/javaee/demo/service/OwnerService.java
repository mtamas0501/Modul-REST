package hu.ulyssys.java.course.javaee.demo.service;

import hu.ulyssys.java.course.javaee.demo.entity.Owner;

import java.util.List;

public interface OwnerService extends CoreService<Owner> {

    Owner findByName(String name);

}
