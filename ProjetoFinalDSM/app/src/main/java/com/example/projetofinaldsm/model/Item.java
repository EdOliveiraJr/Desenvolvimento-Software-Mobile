package com.example.projetofinaldsm.model;

public class Item {
    private static int count_id = 0;
    private final int id;
    private String name;
    private String description;
    private Double price;

    public Item(String name, String description, Double price) {
        this.id = count_id++;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setNome(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return "ID " + id +
                "\nName: " + name +
                "\nDescription: " + description +
                "\nPrice: " + price;
    }
}
