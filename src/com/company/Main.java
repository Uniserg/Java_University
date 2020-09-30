package com.company;

import com.company.CollectionTask.*;
import com.company.Shape.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int repeating = 100;

        Matrix A = new Matrix(new double[][]{
                {1, 2, 2},
                {2, 1, 2}
        });
        Matrix B = new Matrix(new double[][]{
                {2, 10, 6},
                {6, 5, 5},
                {1, 3, 2}
        });


        System.out.println("*".repeat(repeating));
        System.out.println("<Задание на матрицы>\n");

        Matrix C = A.mul(B);
        System.out.println("Перемножение матриц:\n" + C);
        System.out.println("Транспонирование:\n" + C.transpose());
        System.out.println("Возведение в степень:\n" + B.pow(10));


        System.out.println("*".repeat(repeating));
        System.out.println("<Задание на векторы>\n");

        System.out.println("Генерация случайных векторов:");
        Vector3D[] D = Vector3D.generateVectors(5);
        for (var vector : D) {
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

        for (var figure : toAdd) {
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

//        var dict = CollectionTask.FrequencyDict();
//        System.out.println();
//        int count = 0;
//        for (Iterator<String> it = dict.keySet().stream().sorted().iterator(); it.hasNext(); ) {
//            Object s = it.next();
//            count += dict.get(s);
//            System.out.println(s + ": " + dict.get(s));
//        }
//        System.out.println(count);

        HashMap<Character, Integer> myDict = new HashMap<>();
        myDict.put('A', 1);
        var swapping = CollectionTask.Swap(myDict);
        System.out.println(swapping.get(1));
        Integer[][] twoArray = new Integer[][]{{3, 2, 2}, {1, 2}, {1}, {5, 3, 1, 0}};
        Iterator<Integer> it1 = new TwoDimensionalArrayIterator<>(twoArray);
        Object[] array = new Object[]{3, 1, 1, it1, 1, 3, 0, 4};
        Iterator it2 = new ArrayIterator(array);

        Object[][] array2 = new Object[][]{
                {3, 4, it2},
                {new TwoDimensionalArrayIterator<>(twoArray), 1, 0},
                {5, 1, new ArrayIterator<>(new String[]{"Hello", "Java", "and", "COFFEE", "!!"})},
                {2, 4, 0},
        };

        TwoDimensionalArrayIterator it3 = new TwoDimensionalArrayIterator(array2);
//        while (it1.hasNext()) {
//            System.out.print(it1.next() + " ");
//        }

        System.out.println();

//        IteratorsIterator<Integer> twoDimIterator = new IteratorsIterator<>(iters);
//        while (twoDimIterator.hasNext()) {
//            System.out.print(twoDimIterator.next() + " ");
//        }
//        System.out.println();

//        Iterator It = new ArrayIterator(array);

        RecursiveIterator recIt = new RecursiveIterator(it3);

        FlatIterator flIt = new FlatIterator(recIt);
        while (flIt.hasNext()) {
            System.out.print(flIt.next() + " ");
        }

    }
}

