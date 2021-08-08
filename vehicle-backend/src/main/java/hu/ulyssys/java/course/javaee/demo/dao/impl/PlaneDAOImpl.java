package hu.ulyssys.java.course.javaee.demo.dao.impl;

import hu.ulyssys.java.course.javaee.demo.dao.PlaneDAO;
import hu.ulyssys.java.course.javaee.demo.entity.Plane;

import javax.ejb.Stateless;


@Stateless
public class PlaneDAOImpl extends CoreDAOImpl<Plane> implements PlaneDAO {


    @Override
    protected Class<Plane> getManagedClass() {
        return Plane.class;
    }
}
