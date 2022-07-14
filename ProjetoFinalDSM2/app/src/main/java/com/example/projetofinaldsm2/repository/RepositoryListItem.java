package com.example.projetofinaldsm2.repository;

import android.util.Log;
import androidx.annotation.NonNull;
import com.example.projetofinaldsm2.model.Item;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class RepositoryListItem {
    public ArrayList<Item> listItem;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public RepositoryListItem() {
        this.listItem = new ArrayList<Item>();
    }

    public void setItemLisItem(Item item){
        listItem.add(item);
    }

    public ArrayList<Item> getListItem() {
        return listItem;
    }

    public Item getItem(int id){
        String sId = Integer.toString(id);

        Item item = new Item();

        db.collection("item").whereEqualTo("id", sId)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String name = document.getString("name");
                                String description = document.getString("description");
                                Double price = document.getDouble("price");
                                Log.d("getItem", document.getId() + " => " + document.getData());
                                item.setNome(name);
                                item.setDescription(description);
                                item.setPrice(price);
                            }
                        } else {

                            Log.w("Error getItem", "Error getting documents.", task.getException());
                        }
                    }
                });
        return item;
    }

    public void deleteItemListItem(Item item) {
        listItem.remove(item);
    }
}

