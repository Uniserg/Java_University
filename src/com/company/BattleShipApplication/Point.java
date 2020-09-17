package com.company.BattleShipApplication;

public class Point<T> {
    private final T x;
    private final T y;

    public Point(T x, T y){
        this.x = x;
        this.y = y;
    }

    public T x() {
        return x;
    }

    public T y() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
