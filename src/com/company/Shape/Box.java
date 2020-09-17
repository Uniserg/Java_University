package com.company.Shape;
import com.company.Shape.Shape;

import java.util.ArrayList;

public class Box extends Shape {
    private final ArrayList<Shape> container = new ArrayList<>();
    private double occupied;

    public Box(double volume){
        super(volume);
    }

    public boolean add(Shape figure){
        if (occupied + figure.getVolume() > getVolume()) return false;
        container.add(figure);
        occupied += figure.getVolume();
        return true;
    }

    public ArrayList<Shape> getContainer() {
        return container;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Box [");
        for (int i = 0; i < container.size() - 1;i++){
            sb.append(container.get(i)).append("; ");
        }
        sb.append(container.get(container.size() - 1));
        sb.append(']');
        return sb.toString();
    }
}
