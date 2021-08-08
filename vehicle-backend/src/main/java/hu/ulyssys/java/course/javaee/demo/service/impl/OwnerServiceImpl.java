package hu.ulyssys.java.course.javaee.demo.service.impl;

import hu.ulyssys.java.course.javaee.demo.dao.OwnerDAO;
import hu.ulyssys.java.course.javaee.demo.entity.Owner;
import hu.ulyssys.java.course.javaee.demo.service.OwnerService;

import javax.ejb.Stateless;

@Stateless
public class OwnerServiceImpl extends AbstractServiceImpl<Owner> implements OwnerService {

    @Override
    public Owner findByName(String name) {
        return ((OwnerDAO) dao).findByName(name);
    }
}