package com.company;

public class Pyramid extends Shape {
    private final double s;
    private final double h;

    public Pyramid(double s, double h){
        super(1.0 / 3 * s * h);
        this.s = s;
        this.h = h;
    }

    public double getH() {
        return h;
    }

    public double getS() {
        return s;
    }

    @Override
    public String toString() {
        return "Pyramid{" +
                "s=" + s +
                ", h=" + h +
                '}';
    }
}
