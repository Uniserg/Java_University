package com.company;

import java.util.Arrays;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        Matrix a = new Matrix(new double[][]{
                {1, 2, 3},
                {2, 1, 3}
        });
        Matrix b = new Matrix(new double[][]{
                {2, 10, 6},
                {6, 5 , 5},
                {1, 3, 2}
        });

        Matrix c = a.mul(b);
        System.out.println("Перемножение матриц:\n" + c);
        System.out.println("Транспонирование:\n" + c.transpose());
        System.out.println("Возведение в степень:\n" + b.pow(10));

        System.out.println("Генерация случайных векторов:");
        Vector3D[] D = Vector3D.generateVectors(5);
        for (var vector: D){
            System.out.println(vector);
        }

        Box myBox = new Box(1000);
        Shape[] toAdd = {new Ball(5),
                new Cylinder(3, 6),
                new Pyramid(2, 5),
                new Ball(10)
        };

        for (var figure: toAdd){
            System.out.println(myBox.add(figure));
        }

        System.out.println(myBox);


        SelectionWeight<Integer> mySel = new SelectionWeight<Integer>(new Integer[]{1, 2, 3}, new int[]{1, 2, 10});
        System.out.println("Выбор случайного элемента с учетом веса:\n" + mySel.getRandom());
    }
}

