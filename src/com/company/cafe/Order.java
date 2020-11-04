package com.company.cafe;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Order {
    public final Date date;
    private final HashMap<Food, Integer> orders;
    public long number;
    private boolean isReady;
    private double discount;

    public Order(long number, Date date, double discount) {
        this.number = number;
        this.orders = new HashMap<>();
        this.isReady = false;
        this.date = date;
        this.discount = discount;
    }

    public Order(Date date) {
        this.isReady = false;
        this.date = date;
        this.orders = new HashMap<>();
    }

    public double getSum() {
        return orders.keySet().stream().map(food -> food.getPrice() * orders.get(food)).reduce(0d, Double::sum);
    }

    public void add(Food food) {
        orders.put(food, orders.getOrDefault(food, 0) + 1);
    }

    public void remove(Food food) {
        if (orders.containsKey(food)) {
            if (orders.get(food) > 1) {
                orders.compute(food, (k, v) -> v - 1);
            } else
                orders.remove(food);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        int counter = 1;
        result.append(String.format("Заказ №%s, %s\n", number, new SimpleDateFormat("HH:mm:ss dd.MM.YYYY").format(date)));
        for (Map.Entry<Food, Integer> entry : orders.entrySet()) {
            result.append(counter++)
                    .append(
                            String.format(" %s %d x %.2f = %.2f\n",
                                    entry.getKey().getName(),
                                    entry.getValue(),
                                    entry.getKey().getPrice(),
                                    entry.getKey().getPrice() * entry.getValue()));
        }

        result.append(String.format("ИТОГО: %.2f РУБ.", getSum()));
        return result.toString();
    }

    public boolean isIsReady() {
        return isReady;
    }

    public void setIsReady(boolean isReady) {
        this.isReady = isReady;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setNumber(long number) {
        this.number = number;
    }

}
