package com.example.projetofinaldsm2.model;

import java.util.ArrayList;

public class Box {
    private static int count_id = 0;
    private final int id;
    private String name;
    private String description;
    private Double price;
    private ArrayList<Item> listItem;

    public Box(){
        this.id = -1;
    }

    public Box(String name, String description) {
        this.id = count_id++;
        this.name = name;
        this.description = description;
        price = 0.0;
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

    public void setItemBox(Item item) {
        listItem.add(item);
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
        return "Box:" +
                "\nid=" + id +
                "\n name='" + name + '\'' +
                "\n description='" + description + '\'' +
                "\n ListItem=" + listItem +
                "\n Price=" + price;
    }
}
