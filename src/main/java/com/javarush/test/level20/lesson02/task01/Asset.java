package com.javarush.test.level20.lesson02.task01;


import org.apache.log4j.Logger;

public class Asset {

    final static Logger logger = Logger.getLogger(Asset.class);

    public Asset(String name) {
        this.name = name;
    }

    static {logger.info("test");}

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
