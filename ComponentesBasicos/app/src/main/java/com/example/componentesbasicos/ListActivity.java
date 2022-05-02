package com.example.componentesbasicos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    ArrayList<String> listInfo;
    ArrayAdapter adapter;
    ListView listViewInfo;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        editText = findViewById(R.id.editText);
        listInfo = new ArrayList<String>();

    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_list_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void addList(View view){
        if(!editText.getText().toString().equals("")){
            listInfo.add(editText.getText().toString());
            editText.setText("");
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listInfo);
            listViewInfo = (ListView) findViewById(R.id.listViewInfo);
            listViewInfo.setAdapter(adapter);
            listViewInfo.setSelector(android.R.color.holo_blue_light);
        }
    }

    public void cancel(View view){
        finish();
    }
}