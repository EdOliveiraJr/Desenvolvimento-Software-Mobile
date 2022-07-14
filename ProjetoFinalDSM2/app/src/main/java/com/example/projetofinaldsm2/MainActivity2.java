package com.example.projetofinaldsm2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    public static int clickInItem = 1;
    public static int clickInBox = 2;
    public static int clickInOrder = 3;

    public static int clickInAdd = 4;
    public static int clickInEdit = 5;

    private int typeList;

    public static int index;

    public static ArrayAdapter adapterItem;
    public static ArrayAdapter adapterBox;
    public static ArrayAdapter adapterOrder;

    public static ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        index = -1;
        typeList = -1;

        adapterItem = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ActivityAddEditItem.repositoryListItem.getListItem());
        adapterBox = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ActivityAddEditBox.repositoryListBox.getListBox());
        adapterOrder = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ActivityAddEditOrder.repositoryListOrder.getListOrder());

        listView = (ListView) findViewById(R.id.listViewBoxMain2);

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
            case R.id.settings:
                btnSettings();
                break;
            case R.id.about:
                btnAbout();
                break;
        }
        return true;
    }

    //@Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if(requestCode == clickInAdd){
//            if(resultCode == ActivityAddEditItem.clickInSave){
//                listView.setAdapter(adapterItem);
//                listView.setSelector(android.R.color.holo_orange_dark);
//                adapterItem.notifyDataSetChanged();
//                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                        Toast.makeText(MainActivity2.this, ""+ ActivityAddEditItem.repositoryListItem.getListItem().get(i), Toast.LENGTH_SHORT);
//                        index = i;
//                    }
//                });
//
//            }else if(resultCode == ActivityAddEditBox.clickInSave ){
//                listView.setAdapter(adapterBox);
//                listView.setSelector(android.R.color.holo_orange_dark);
//                adapterBox.notifyDataSetChanged();
//                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                        Toast.makeText(MainActivity2.this, ""+ ActivityAddEditBox.repositoryListBox.getListBox().get(i).toString(), Toast.LENGTH_SHORT);
//                        index = i;
//                    }
//                });
//            }else if(resultCode == ActivityAddEditOrder.clickInSave){
//                listView.setAdapter(adapterOrder);
//                listView.setSelector(android.R.color.holo_orange_dark);
//                adapterOrder.notifyDataSetChanged();
//                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                        Toast.makeText(MainActivity2.this, ""+ ActivityAddEditOrder.repositoryListOrder.getListOrder().get(i).toString(), Toast.LENGTH_SHORT);
//                        index = i;
//                    }
//                });
//            }
//        }
//    }

    ActivityResultLauncher<Intent> activityResultLaunch = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == clickInAdd){
                        if(result.getResultCode() == ActivityAddEditItem.clickInSave){
                            listView.setAdapter(adapterItem);
                            listView.setSelector(android.R.color.holo_orange_dark);
                            adapterItem.notifyDataSetChanged();
                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                    Toast.makeText(MainActivity2.this, ""+ ActivityAddEditItem.repositoryListItem.getListItem().get(i), Toast.LENGTH_SHORT);
                                    index = i;
                                }
                            });

                        }else if(result.getResultCode() == ActivityAddEditBox.clickInSave ){
                            listView.setAdapter(adapterBox);
                            listView.setSelector(android.R.color.holo_orange_dark);
                            adapterBox.notifyDataSetChanged();
                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                    Toast.makeText(MainActivity2.this, ""+ ActivityAddEditBox.repositoryListBox.getListBox().get(i).toString(), Toast.LENGTH_SHORT);
                                    index = i;
                                }
                            });
                        }else if(result.getResultCode() == ActivityAddEditOrder.clickInSave){
                            listView.setAdapter(adapterOrder);
                            listView.setSelector(android.R.color.holo_orange_dark);
                            adapterOrder.notifyDataSetChanged();
                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                    Toast.makeText(MainActivity2.this, ""+ ActivityAddEditOrder.repositoryListOrder.getListOrder().get(i).toString(), Toast.LENGTH_SHORT);
                                    index = i;
                                }
                            });
                        }
                    }
                }
            });


    public void btnItem(View view){

        if (ActivityAddEditItem.repositoryListItem.getListItem().isEmpty()){
            this.typeList = clickInItem;
        }else{
            this.typeList = clickInItem;

            listView.setAdapter(adapterItem);
            listView.setSelector(android.R.color.holo_orange_dark);
            adapterItem.notifyDataSetChanged();

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(MainActivity2.this, ""+ ActivityAddEditItem.repositoryListItem.getListItem().get(i).toString(), Toast.LENGTH_SHORT);
                    index = i;
                }
            });
        }

    }

    public void btnBox(View view){
        if(ActivityAddEditBox.repositoryListBox.getListBox().isEmpty()) {
            this.typeList = clickInBox;
        }else{
            this.typeList = clickInBox;
            listView.setAdapter(adapterBox);
            listView.setSelector(android.R.color.holo_orange_dark);
            adapterBox.notifyDataSetChanged();

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(MainActivity2.this, ""+ ActivityAddEditBox.repositoryListBox.getListBox().get(i).toString(), Toast.LENGTH_SHORT);
                    index = i;
                }
            });
        }
    }

    public void btnOrder(View view) {
        if(ActivityAddEditOrder.repositoryListOrder.getListOrder().isEmpty()) {
            this.typeList = clickInOrder;
        }else{
            this.typeList = clickInOrder;
            listView.setAdapter(adapterOrder);
            listView.setSelector(android.R.color.holo_orange_dark);
            adapterOrder.notifyDataSetChanged();

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(MainActivity2.this, ""+ ActivityAddEditOrder.repositoryListOrder.getListOrder().get(i).toString(), Toast.LENGTH_SHORT);
                    index = i;
                }
            });
        }
    }

    public void btnAdd(){
        if(typeList == clickInItem){
            Intent intent = new Intent(this, ActivityAddEditItem.class);
            activityResultLaunch.launch(intent);
        }else if(typeList == clickInBox) {
            Intent intent = new Intent(this, ActivityAddEditBox.class);
            activityResultLaunch.launch(intent);
        }else if(typeList == clickInOrder) {
            Intent intent = new Intent(this, ActivityAddEditOrder.class);
            activityResultLaunch.launch(intent);
        }

    }

    public void btnSettings(){
        // TODO: 26/06/2022  
    }

    public void btnAbout(){
        Intent intent = new Intent(this, ActivityAbout.class);
        startActivity(intent);
    }
}