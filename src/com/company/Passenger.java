package com.company;

public class Passenger extends Car {
    private final String brand;

    public Passenger(String name, String color, double maxSpeed, String typeTransmission, double curSpeed, double price, String brand) {
        super(name, color, maxSpeed, typeTransmission, curSpeed, price);
        this.brand = brand;
    }

    @Override
    double start() {
        return 0;
    }

    @Override
    double stop() {
        return getMaxSpeed();
    }

    @Override
    double accelerate(int speed) {
        return getMaxSpeed();
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "brand='" + brand + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return getName().compareTo(((Car) o).getName());
    }
}
