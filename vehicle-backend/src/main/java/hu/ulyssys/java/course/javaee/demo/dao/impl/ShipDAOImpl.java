package hu.ulyssys.java.course.javaee.demo.dao.impl;

import hu.ulyssys.java.course.javaee.demo.dao.ShipDAO;
import hu.ulyssys.java.course.javaee.demo.entity.Ship;

import javax.ejb.Stateless;

@Stateless
public class ShipDAOImpl extends CoreDAOImpl<Ship> implements ShipDAO {


    @Override
    protected Class<Ship> getManagedClass() {
        return Ship.class;
    }
}
