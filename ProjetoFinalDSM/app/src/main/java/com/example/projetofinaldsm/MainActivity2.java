package com.example.projetofinaldsm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {
    private final int clickInItem = 1;
    private final int clickInBox = 2;
    private int type = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
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
    }

    public void btnBox(View view){
        this.type = clickInBox;
    }

    public void btnAdd(){
        if(this.type == clickInItem){
            Intent intent = new Intent(this, ActivityAddEditItem.class);
            startActivity(intent);
        }
        if(this.type == clickInBox) {
            Intent intent = new Intent(this, ActivityAddEditBox.class);
            startActivity(intent);
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