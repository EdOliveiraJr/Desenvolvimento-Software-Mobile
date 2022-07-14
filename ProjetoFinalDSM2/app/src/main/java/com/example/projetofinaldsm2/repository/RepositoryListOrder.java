package com.example.projetofinaldsm2.repository;

import com.example.projetofinaldsm2.model.Order;

import java.util.ArrayList;

public class RepositoryListOrder {
    public ArrayList<Order> listOrder;

    public RepositoryListOrder() {
        this.listOrder = new ArrayList<>();
    }

    public void setListOrder(Order order){
        listOrder.add(order);
    }

    public ArrayList<Order> getListOrder() {
        return listOrder;
    }

    public void deleteBoxListOrder(Order order) {
        listOrder.remove(order);
    }

}
