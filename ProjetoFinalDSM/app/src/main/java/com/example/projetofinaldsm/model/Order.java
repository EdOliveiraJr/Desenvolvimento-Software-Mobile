package com.example.projetofinaldsm.model;

import java.util.ArrayList;

public class Order {
    private static int count_id = 0;
    private final int id;
    ArrayList<Box> listBox;
    ArrayList<Item> extraItem;
    private String nameClient;
    private String deliveryAddress;
    private String observations;
    private Double price;

    public Order(String nameClient, String deliveryAddress, String observations) {
        this.id = count_id++;;
        this.nameClient = nameClient;
        this.deliveryAddress = deliveryAddress;
        this.observations = observations;
        price = 0.0;
        listBox = new ArrayList<>();
        extraItem = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public ArrayList<Box> getListBox() {
        return listBox;
    }

    public void setListBox(ArrayList<Box> listBox) {
        this.listBox = listBox;
    }

    public ArrayList<Item> getExtraItem() {
        return extraItem;
    }

    public void setExtraItem(ArrayList<Item> extraItem) {
        this.extraItem = extraItem;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice() {
        Double sum = 0.0;

        for (Box b : listBox) {
            sum += b.getPrice();
        }

        for (Item i : extraItem) {
            sum += i.getPrice();
        }

        this.price = price;
    }

    @Override
    public String toString() {
        return "Order:" +
                "\nid=" + id +
                "\n listBox=" + listBox +
                "\n extraItem=" + extraItem +
                "\n nameClient='" + nameClient + '\'' +
                "\n deliveryAddress='" + deliveryAddress + '\'' +
                "\n observations='" + observations + '\'' +
                "\n price=" + price ;
    }
}
