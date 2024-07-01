package org.ben.aop.model;

import org.ben.aop.proxy.HouseDeal;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-25
 * Time: 11:47
 */
public class landlord implements HouseDeal {
    public landlord() {
    }

    public landlord(String name) {
        this.name = name;
    }

    public String name;

    @Override
    public void seal() {
        System.out.println("landlord " + this.name + " seal");
    }

    @Override
    public void rent() {
        System.out.println("landlord " + this.name + " rent");
    }
}
