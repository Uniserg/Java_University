package com.company.BattleShipApplication;

enum TypeShip{
    singleDeck,
    doubleDeck,
    tripleDeck,
    fourDeck
}

public class Ship {
    private final Point<Integer> areaFrom;
    private final Point<Integer> areaTo;
    private final TypeShip type;
    private int hits = 0;

    public Ship(TypeShip type, Point<Integer> coord, int dX, int dY){
        this.type = type;
        areaFrom = new Point<>(coord.x() - 1, coord.y() - 1);
        areaTo = new Point<>(coord.x() + type.ordinal() * dX + 1, coord.y() + type.ordinal() * dY + 1);
    }

    public boolean isDestroy(){
        return  (getHits() == getType().ordinal() + 1);
    }

    public Point<Integer> getAreaFrom() {
        return areaFrom;
    }

    public Point<Integer> getAreaTo() {
        return areaTo;
    }

    public TypeShip getType() {
        return type;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    @Override
    public String toString() {
        return "Ship{" +
                ", areaFrom=" + areaFrom +
                ", areaTo=" + areaTo +
                ", type=" + type +
                ", hits=" + hits +
                '}';
    }
}
