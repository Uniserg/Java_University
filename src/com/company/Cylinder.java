package com.company;

public class Cylinder extends SolidOfRevolution {
    private final double height;

    public Cylinder(double radius, double height){
        super(radius,Math.PI * radius * radius * height );
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                ", radius=" + getRadius() +
                '}';
    }
}