package com.example.projetofinaldsm.repository;

import com.example.projetofinaldsm.model.Item;

import java.util.ArrayList;

public class RepositoryListItem {
    public ArrayList<Item> listItem;

    public RepositoryListItem() {
        this.listItem = new ArrayList<Item>();
    }

    public void setItemLisItem(Item item){
        listItem.add(item);
    }

    public ArrayList<Item> getListItem() {
        return listItem;
    }

    public void deleteItemListItem(Item item) {
        listItem.remove(item);
    }
}

