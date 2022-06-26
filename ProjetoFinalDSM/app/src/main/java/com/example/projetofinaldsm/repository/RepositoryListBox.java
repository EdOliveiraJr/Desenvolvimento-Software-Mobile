package com.example.projetofinaldsm.repository;

import com.example.projetofinaldsm.model.Box;


import java.util.ArrayList;

public class RepositoryListBox {
    public ArrayList<Box> listBox;

    public RepositoryListBox() {
        this.listBox = new ArrayList<Box>();
    }

    public void setBoxListBox(Box box){
        listBox.add(box);
    }

    public ArrayList<Box> getListBox() {
        return listBox;
    }

    public void deleteBoxListBox(Box box) {
        listBox.remove(box);
    }
}
