package com.company;

public  abstract class SolidOfRevolution extends Shape {
    private final double radius;

    protected SolidOfRevolution(double radius, double volume) {
        super(volume);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
