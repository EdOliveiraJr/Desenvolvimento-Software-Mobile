package com.example.projetofinaldsm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;

public class ActivityAddEditItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);
    }

    public void btnSaveItem(View view){

    }

    public void btnCancelItem(View view){
        finish();
    }
}