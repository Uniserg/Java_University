package com.company.cafe;


public class Food {
    private String name;
    private String ingrediens;
    private double price;
    private int portion; //in gramms

    public Food(String name, String ingrediens, double price, int portion) {
        this.name = name;
        this.ingrediens = ingrediens;
        this.price = price;
        this.portion = portion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngrediens() {
        return ingrediens;
    }

    public void setIngrediens(String ingrediens) {
        this.ingrediens = ingrediens;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPortion() {
        return portion;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }

}
