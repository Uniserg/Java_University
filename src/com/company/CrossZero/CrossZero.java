package com.company.CrossZero;

import java.util.Scanner;
import java.util.function.Function;


public class CrossZero {
    private static final Character[] characters = {'x', 'o'};
    private final char[][] field;
    private final Player player1;
    private final Player player2;
    private final int cEnd;
    private final int sizeT;
    private int counter = 0;
    private String winner = null;


    public CrossZero(int sizeField, int cEnd) {

        if (sizeField < cEnd) {
            throw new IllegalArgumentException();
        }
        sizeT = String.valueOf(cEnd).length() / 2;
        player1 = new Player(inputPlayer(), characters[0]);
        counter++;
        player2 = new Player(inputPlayer(), characters[1]);

        field = new char[sizeField][sizeField];
        this.cEnd = cEnd;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = '.';
            }
        }
    }

    private void enumerate() {
        System.out.print("  ");
        for (int i = 0; i < field.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private void print() {
        enumerate();

        for (int i = 0; i < field.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println(i);
        }

        enumerate();
    }

    private String inputPlayer() {
        System.out.print("Ввведите свое имя <Игрок" + (counter + 1) + ">: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println();
        return name;
    }

    private boolean checkingWin(Player player, Function<Integer, Character> check, Function<Integer, Boolean> isArea) {
        int k = 0;

        for (int i = -cEnd + 1; i < cEnd - 1; i++) {
            if (isArea.apply(i))
                if (check.apply(i) == player.ch) {
                    k++;
                    if (k == cEnd) {
                        winner = player.name;
                        return true;
                    }
                } else {
                    break;
                }
        }
        return false;
    }

    private boolean isInArea(int x, int y) {
        return x > -1 && x < field.length && y > -1 && y < field.length;
    }

    private boolean isEnd(int x, int y, Player player) {
        return
                checkingWin(player, (o) -> field[x + o][y], (o) -> isInArea(x + o, y)) ||
                        checkingWin(player, (o) -> field[x][y + o], (o) -> isInArea(x, y + o)) ||
                        checkingWin(player, (o) -> field[x + o][y + o], (o) -> isInArea(x + o, y + o)) ||
                        checkingWin(player, (o) -> field[x + o][y - o], (o) -> isInArea(x + o, y - o));
    }

//    private boolean checkTie() {
//    }

    private boolean turn() {
        Player cur;
        int x, y;
        Scanner scanner = new Scanner(System.in);

        if (counter % 2 == 1) {
            cur = player1;
        } else {
            cur = player2;
        }

        while (true) {

            System.out.print("Ход игрока:" + cur.name + ". Введите координаты x y (через пробел) => ");
            String iX = scanner.next();
            String iY = scanner.next();
            try {
                x = Integer.parseInt(iX);
                y = Integer.parseInt(iY);
            } catch (NumberFormatException e) {
                System.out.println("Введены некорректные данные!");
                continue;
            }

            System.out.println();

            if (!isInArea(x, y)) {
                System.out.println("Введены неправильные координаты, попробуйте еще раз!");
                continue;
            }

            if (field[x][y] == '.') {
                break;
            } else {
                System.out.println("Это место уже занято, выберите другое.");
            }

        }

        field[x][y] = cur.ch;
        counter++;

        return isEnd(x, y, cur);
    }

    private void process() {
        do {
            print();
        } while (!turn());

        print();
        System.out.println("Игра окончена! Победитель - " + winner);
    }

    public void run() {
        process();
    }

}
