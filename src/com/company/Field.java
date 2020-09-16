package com.company;

import java.util.Random;

public class Field {
    private final Ship[] ships = new Ship[10];
    private final char[][] field = new char[10][10];

    public Field(){

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = ' ';
            }
        }
        int k = 1;
        int u = 0;
        TypeShip [] typeShips = TypeShip.values();
        for (int i = typeShips.length - 1; i >= 0; i--){
            for (int j = 0; j < k; j++){
                ships[u++] = generate(typeShips[i]);
            }
            k++;
        }
    }

    Ship generate(TypeShip type){
        Random random = new Random();
        Ship ship;
        do {
            int dX = random.nextInt(2);
            int dY = (dX == 0) ? 1 : 0;
            if (dX == 0) {
                ship = new Ship(type, new Point<>(random.nextInt(10),
                                                  random.nextInt(10 - type.ordinal())), dX, dY);
            } else {
                ship = new Ship(type,new Point<>(random.nextInt(10 - type.ordinal()),
                                                 random.nextInt(10)), dX, dY);
            }

        }while (!checkLocationShip(ship));

        return ship;
    }

    private boolean isIntersection(Point<Integer> fromA, Point<Integer> toA, Point<Integer> fromB, Point<Integer> toB){
        return (fromA.x() <= fromB.x() + 1 && fromB.x() + 1 <= toA.x() || fromA.x() <= toB.x() - 1 && toB.x() - 1 <= toA.x()) &&
                (fromA.y() <= fromB.y() + 1 && fromB.y() + 1 <= toA.y() || fromA.y() <= toB.y() - 1 && toB.y() - 1 <= toA.y());
    }

    private boolean checkLocationShip(Ship checkingShip){
        boolean result = true;
        int i = 0;
        while (i < ships.length && ships[i] != null){
            if (isIntersection(ships[i].getAreaFrom(), ships[i].getAreaTo(), checkingShip.getAreaFrom(), checkingShip.getAreaTo())){
                result = false;
                break;
            }
            i++;
        }
        return result;
    }

    public char[][] getField() {
        return field;
    }

    public Ship[] getShips() {
        return ships;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Ship ship : ships){
                for (int x = ship.getAreaFrom().x() + 1; x < ship.getAreaTo().x(); x++){
                    for (int y = ship.getAreaFrom().y() + 1; y < ship.getAreaTo().y(); y++){
                        field[x][y] = 'S';
                    }
                }
        }

        for (int i = 0; i < field.length; i ++){
            result.append(i).append(" ");
        }
        result.append('\n');
        for (int i = 0; i < field.length; i++){
            for (int j = 0; j < field.length; j++){
                result.append(field[i][j]).append(" ");
            }
            result.append(i).append("\n");
        }
        return result.toString();
    }
}
