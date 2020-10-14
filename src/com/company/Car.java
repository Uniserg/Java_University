package com.company;

public abstract class Car implements Comparable {
    private String name;
    private String color;
    private double maxSpeed;
    private String typeTransmission;
    private double curSpeed;
    private double price;

    public Car(String name, String color, double maxSpeed, String typeTransmission, double curSpeed, double price) {
        this.name = name;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.typeTransmission = typeTransmission;
        this.curSpeed = curSpeed;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurSpeed() {
        return curSpeed;
    }

    public void setCurSpeed(double curSpeed) {
        this.curSpeed = curSpeed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTypeTransmission() {
        return typeTransmission;
    }

    public void setTypeTransmission(String typeTransmission) {
        this.typeTransmission = typeTransmission;
    }

    abstract double start();

    abstract double stop();

    abstract double accelerate(int speed);


}
