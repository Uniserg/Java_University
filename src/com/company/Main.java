package com.company;

import com.company.CollectionTask.CollectionTask;
import com.company.Shape.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        int repeating = 100;

        Matrix a = new Matrix(new double[][]{
                {1, 2, 2},
                {2, 1, 2}
        });
        Matrix b = new Matrix(new double[][]{
                {2, 10, 6},
                {6, 5, 5},
                {1, 3, 2}
        });


        System.out.println("*".repeat(repeating));
        System.out.println("<Задание на матрицы>\n");

        Matrix c = a.mul(b);
        System.out.println("Перемножение матриц:\n" + c);
        System.out.println("Транспонирование:\n" + c.transpose());
        System.out.println("Возведение в степень:\n" + b.pow(10));


        System.out.println("*".repeat(repeating));
        System.out.println("<Задание на векторы>\n");

        System.out.println("Генерация случайных векторов:");
        Vector3D[] D = Vector3D.generateVectors(5);
        for (var vector: D){
            System.out.println(vector);
        }


        System.out.println("*".repeat(repeating));
        System.out.println("<Задание на фигуры>\n");

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


        System.out.println("*".repeat(repeating));
        System.out.println("<Выбор элемента с учетом веса>");
        SelectionWeight<Integer> mySel = new SelectionWeight<>(new Integer[]{1, 2, 3}, new int[]{1, 2, 10});
        System.out.println("Выбор случайного элемента с учетом веса: " + mySel.getRandom());


//        Application.run();


        System.out.println("*".repeat(repeating));
        System.out.println("<Задание на коллекции>\n");

        ArrayList<Integer> myList = new ArrayList<>(Arrays.asList(1, 2, 4, 4));
        System.out.println("Удаление дубликатов: " + CollectionTask.removeDuplicate(myList));

        int n = 200000;
        int m = 20000;
        double tArrayList = CollectionTask.measureTime(new ArrayList<>(), n, m);
        double tLinkedList = CollectionTask.measureTime(new LinkedList<>(), n, m);
        System.out.println("Время работы ArrayList(" + n + ", " + m + ")" + " = " + tArrayList);
        System.out.println("Время работы LinkedList(" + n + ", " + m + ")" + " = " + tLinkedList);

        var dict = CollectionTask.FrequencyDict();
        System.out.println();

        int count = 0;

        for (Iterator<String> it = dict.keySet().stream().sorted().iterator(); it.hasNext(); ) {
            Object s = it.next();
            count += dict.get(s);
            System.out.println(s + ": " + dict.get(s));
        }
        System.out.println(count);
    }
}

