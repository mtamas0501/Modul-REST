package hu.ulyssys.java.course.javaee.demo.dao;

import hu.ulyssys.java.course.javaee.demo.entity.Owner;

public interface OwnerDAO extends CoreDAO<Owner> {

    Owner findByName(String name);

}