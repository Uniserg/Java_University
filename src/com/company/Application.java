package com.company;

import java.util.Random;
import java.util.Scanner;

public class Application {
    private static Field userField;
    private static Field computerField;
    private static boolean isEnd = false;
    private static boolean winner = false;

    private static void indent(){
        for (int k = 0; k < 10; k++){
            System.out.print('\t');
        }
    }

    private static void printEnum(){
        for (int k = 0; k < 2; k++){
            System.out.print("  ");
            for (int i = 0; i < 10; i++){
                System.out.print(i + " ");
            }
            indent();
        }
        System.out.println();
    }

    private static void printRow(int x, char[][] field){
        System.out.print(x + " ");
        for (int y = 0; y < 10; y++){
            System.out.print(field[x][y] + " ");
        }
        System.out.print(x);
    }

    private static void print(){
        System.out.print("\t  " + "Your field: ");
        indent();
        System.out.print("\t\t" + "Computer field: " + '\n');
        printEnum();
        for (int x = 0; x < 10; x++){
            printRow(x, userField.getField());
            indent();
            printRow(x, computerField.getField());
            System.out.println();
        }
        printEnum();
    }

    private static boolean isFieldEmpty(Field field){
        for (Ship ship: field.getShips()){
            if (ship.getHits() != ship.getType().ordinal() + 1) return false;
        }
        return true;
    }

    private static void fillArea(Field field, Point<Integer> areaFrom, Point<Integer> areaTo){
        for (int i = Math.max(areaFrom.x(), 0); i <= Math.min(areaTo.x(), 9); i++){
            for (int j = Math.max(areaFrom.y(), 0); j <= Math.min(areaTo.y(), 9); j++){
                field.getField()[i][j] = '*';
            }
        }
    }

    private static void markDestroyed(Field field, Point<Integer> areaFrom, Point<Integer> areaTo){
        for (int i = areaFrom.x() + 1; i < areaTo.x(); i++){
            for (int j = areaFrom.y() + 1; j < areaTo.y(); j++){
                field.getField()[i][j] = 'V';
            }
        }
    }

    private  static boolean checkHit(int x, int y, Field field){
        for (Ship ship: field.getShips()){
            if
            (ship.getAreaFrom().x() + 1 <= x && x < ship.getAreaTo().x() &&
                    ship.getAreaFrom().y() + 1 <= y && y < ship.getAreaTo().y()){
                ship.setHits(ship.getHits() + 1);
                field.getField()[x][y] = 'X';
                if (ship.isDestroy()){
                    fillArea(field, ship.getAreaFrom(), ship.getAreaTo());
                    markDestroyed(field, ship.getAreaFrom(), ship.getAreaTo());
                    isEnd = isFieldEmpty(field);
                }
                return !isEnd;
            }else {
                field.getField()[x][y] = '*';
            }
        }
        return false;
    }

    private static boolean isOccupied(int x, int y, Field field) {
        char check = field.getField()[x][y];
        if (check == '*' || check == 'X' || check == 'V') {
            System.out.println("Данная координата уже была выбрана, попробуйте еще раз...");
            return true;
        }
        return false;
    }

    private static boolean isIncorrectCoords(int x, int y){
        if (!(x >= 0 && x < 10 && y >= 0 && y < 10)) {
            System.out.println("Неверный диапазон координат, попробуйте еще раз...");
            return true;
        }
        return false;
    }

    private static void turnComputer(){
        Random random = new Random();
        int x , y;
        do {
            x = random.nextInt(10);
            y = random.nextInt(10);
        } while (isOccupied(x, y, userField) || checkHit(x ,y, userField));
    }

    private static void turnUser(){
        Scanner scanner = new Scanner(System.in);
        int x, y;
        do {
            print();
            do{
                System.out.print("Введите координаты <x> <y> для выстрела: ");
                x = scanner.nextInt();
                y = scanner.nextInt();
            } while (isIncorrectCoords(x, y) || isOccupied(x, y, computerField));
        } while (checkHit(x, y, computerField));
    }

    private static void Process(){
        while (true){
            turnUser();
            if (isEnd) {
                winner = true;
                break;
            }
            turnComputer();
            if (isEnd) break;
        }
        print();
        System.out.println("Победитель - " + ((winner) ? "Вы" : "Компьютер"));
    }

    public static void run(){
        userField = new Field();
        computerField = new Field();
        Process();
    }
}
