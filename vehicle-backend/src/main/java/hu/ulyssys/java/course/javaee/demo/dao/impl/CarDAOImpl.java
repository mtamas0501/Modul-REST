package hu.ulyssys.java.course.javaee.demo.dao.impl;

import hu.ulyssys.java.course.javaee.demo.dao.CarDAO;
import hu.ulyssys.java.course.javaee.demo.entity.Car;

import javax.ejb.Stateless;

@Stateless
public class CarDAOImpl extends CoreDAOImpl<Car> implements CarDAO {


    @Override
    protected Class<Car> getManagedClass() {
        return Car.class;
    }
}
