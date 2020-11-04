package com.company.cafe;

import java.util.ArrayList;


public class Cafe {
    private final ArrayList<Order> orders;
    private long currentNumber = 0;
    private ArrayList<Food> kitchen;
    private ArrayList<Food> bar;
    private ArrayList<Food> stopList;

    public Cafe(ArrayList<Food> kitchen, ArrayList<Food> bar, ArrayList<Food> stopList) {
        this.kitchen = kitchen;
        this.bar = bar;
        this.stopList = stopList;
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        order.setNumber(++currentNumber);
        orders.add(order);
    }

    public void closeOrder(Order order) {
        orders.remove(order);
    }

    public void addToStopList(Food food) {
        stopList.add(food);
    }

    public void addToKitchen(Food food) {
        kitchen.add(food);
    }

    public void removeFromKitchen(Food food) {
        kitchen.remove(food);
    }

    public void addToBar(Food food) {
        kitchen.add(food);
    }

    public void removeFromBar(Food food) {
        kitchen.remove(food);
    }

    public ArrayList<Food> getKitchen() {
        return kitchen;
    }

    public void setKitchen(ArrayList<Food> kitchen) {
        this.kitchen = kitchen;
    }

    public ArrayList<Food> getKitchenToday() {
        ArrayList<Food> result = new ArrayList<>();

        for (Food food : kitchen) {
            if (!stopList.contains(food)) {
                result.add(food);
            }
        }

        return result;
    }

    public ArrayList<Food> getBarToday() {
        ArrayList<Food> result = new ArrayList<>();

        for (Food food : bar) {
            if (!stopList.contains(food)) {
                result.add(food);
            }
        }

        return result;
    }

    public ArrayList<Food> getBar() {
        return bar;
    }

    public void setBar(ArrayList<Food> bar) {
        this.bar = bar;
    }

    public ArrayList<Food> getStopList() {
        return stopList;
    }

    public void setStopList(ArrayList<Food> stopList) {
        this.stopList = stopList;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

}
