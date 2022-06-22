package com.example.projetofinaldsm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.projetofinaldsm.model.Box;
import com.example.projetofinaldsm.model.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private final int clickInItem = 1;
    private final int clickInBox = 2;
    private int type = -1;

    public static int index;
    public static ArrayList<Item> listItem;
    public static ArrayList<Box> listBox;
    public static ArrayList list;

    public static ArrayAdapter adapter;
    public static ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        index = -1;

        listBox = new ArrayList<>();
        listItem = new ArrayList();
        list = new ArrayList();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listview = (ListView) findViewById(R.id.listViewMain2);
        listview.setAdapter(adapter);
        listview.setSelector(android.R.color.holo_orange_dark);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity2.this, ""+list.get(i).toString(), Toast.LENGTH_SHORT);
                index = i;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main2, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.add:
                btnAdd();
                break;
            case R.id.edit:
                btnEdit();
                break;
            case R.id.delete:
                btnDelete();
                break;
            case R.id.settings:
                btnSettings();
                break;
            case R.id.about:
                btnAbout();
                break;
        }
        return true;
    }

    public void btnItem(View view){
        this.type = clickInItem;
        list.clear();
        listItem.add(new Item("chocolate","prestigio", 20.00));
        list = listItem;
        adapter.notifyDataSetChanged();
    }

    public void btnBox(View view){
        this.type = clickInBox;
        list.clear();
        Item item = new Item("chocolate","prestigio", 20.00);
        Box box = new Box("nomorados", "namorados");
        box.setItemBox(item);
        list = box.getListItem();
        adapter.notifyDataSetChanged();
    }

    public void btnAdd(){
        if(this.type == clickInItem){
            Intent intent = new Intent(this, ActivityAddEditItem.class);
            startActivityForResult(intent, clickInItem);
        }
        if(this.type == clickInBox) {
            Intent intent = new Intent(this, ActivityAddEditBox.class);
            startActivityForResult(intent, clickInBox);
        }

    }

    public void btnEdit(){
        if(this.type == clickInItem){
            Intent intent = new Intent(this, ActivityAddEditItem.class);
            startActivity(intent);
        }
        if(this.type == clickInBox) {
            Intent intent = new Intent(this, ActivityAddEditBox.class);
            startActivity(intent);
        }
    }

    public void btnDelete(){

    }

    public void btnSettings(){

    }

    public void btnAbout(){

    }
}