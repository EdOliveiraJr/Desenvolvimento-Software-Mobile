package com.example.projetofinaldsm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import com.example.projetofinaldsm.repository.RepositoryListBox;
import com.example.projetofinaldsm.repository.RepositoryListItem;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    public static int clickInItem = 1;
    public static int clickInBox = 2;
    public static int clickInAdd = 3;
    public static int clickInEdit = 4;

    private int typeList;

    public static int index;
    public RepositoryListItem repositoryListItem;
    public RepositoryListBox repositoryListBox;
    public static ArrayList<Box> listBox;
    public static ArrayList<Item> listItem;

    public static ArrayAdapter adapterItem;
    public static ArrayAdapter adapterBox;
    public static ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        index = -1;
        typeList = -1;

        listBox = new ArrayList<>();
        listItem = new ArrayList<>();
        repositoryListItem = new RepositoryListItem();
        repositoryListBox = new RepositoryListBox();

        adapterItem = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItem);

        adapterBox = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listBox);

//        listViewItem = (ListView) findViewById(R.id.listViewItemMain2);
//        listViewBox = (ListView) findViewById(R.id.listViewBoxMain2);

        listView = (ListView) findViewById(R.id.listViewBoxMain2);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity2.this, ""+listItem.get(i).toString(), Toast.LENGTH_SHORT);
                index = i;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity2.this, ""+listBox.get(i).toString(), Toast.LENGTH_SHORT);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == clickInAdd && resultCode == ActivityAddEditItem.clickInSave){
            repositoryListItem = ActivityAddEditItem.repositoryListItem;
            listItem.clear();
            listItem.addAll(repositoryListItem.getListItem());

        }else if (requestCode == clickInAdd && resultCode == ActivityAddEditBox.clickInSave){
            repositoryListBox = ActivityAddEditBox.repositoryListBox;
            listBox.clear();
            listBox.addAll(repositoryListBox.getListBox());
        }
    }

    public void btnItem(View view){

        if (listItem.isEmpty()){
            this.typeList = clickInItem;
        }else{
            this.typeList = clickInItem;

            listView.setAdapter(adapterItem);
            listView.setSelector(android.R.color.holo_orange_dark);
            adapterItem.notifyDataSetChanged();
//
//            repositoryListItem = ActivityAddEditItem.repositoryListItem;
//            listItem.clear();
//            listItem.addAll(repositoryListItem.getListItem());
//            adapterItem.notifyDataSetChanged();

        }

    }

    public void btnBox(View view){
        if(listBox.isEmpty()) {
            this.typeList = clickInBox;
        }else{
            this.typeList = clickInBox;
            listView.setAdapter(adapterBox);
            listView.setSelector(android.R.color.holo_orange_dark);
            adapterBox.notifyDataSetChanged();
//
//            repositoryListBox = ActivityAddEditBox.repositoryListBox;
//            listBox.clear();
//            listBox.addAll(repositoryListBox.getListBox());
//            adapterBox.notifyDataSetChanged();
        }
    }

    public void btnAdd(){
        if(typeList == clickInItem){
            Intent intent = new Intent(this, ActivityAddEditItem.class);
            startActivityForResult(intent, clickInAdd);
        }else if(typeList == clickInBox) {
            Intent intent = new Intent(this, ActivityAddEditBox.class);
            startActivityForResult(intent, clickInAdd);
        }

    }

    public void btnEdit(){
        if(typeList == clickInItem){
            Intent intent = new Intent(this, ActivityAddEditItem.class);
            startActivityForResult(intent, clickInEdit);
        }else if(typeList == clickInBox) {
            Intent intent = new Intent(this, ActivityAddEditBox.class);
            startActivityForResult(intent, clickInEdit);
        }
    }

    public void btnDelete(){
        // TODO: 26/06/2022  
    }

    public void btnSettings(){
        // TODO: 26/06/2022  
    }

    public void btnAbout(){
        // TODO: 26/06/2022  
    }
}