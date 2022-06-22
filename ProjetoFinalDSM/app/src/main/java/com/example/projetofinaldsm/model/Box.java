package com.example.projetofinaldsm.model;

import java.util.ArrayList;

public class Box {
    private static int count_id = 0;
    ArrayList<Item> listItem;
    private final int id;
    private String name;
    private String description;
    private Double price;

    public Box(String name, String description) {
        this.id = count_id++;
        this.name = name;
        this.description = description;
        listItem = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Item> getListItem() {
        return listItem;
    }

    public void setListItem(ArrayList<Item> listItem) {
        this.listItem = listItem;
    }

    public void setPrice(ArrayList<Item> listItem){
        Double value = 0.0;
        for (Item e: listItem ) {
            value += e.getPrice();
        }
        this.price = value;
    }

    public Double getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return "Box{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ListItem=" + listItem +
                '}';
    }
}
