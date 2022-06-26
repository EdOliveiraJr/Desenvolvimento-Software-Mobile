package com.example.projetofinaldsm;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetofinaldsm.model.Box;
import com.example.projetofinaldsm.model.Item;
import com.example.projetofinaldsm.repository.RepositoryListBox;

import java.sql.Array;
import java.util.ArrayList;

public class ActivityAddEditBox extends AppCompatActivity {
    public static int clickInSave = 5;
    public static int clickInCancel = 6;

    public static RepositoryListBox  repositoryListBox;
    public static ArrayList<Box> listBox;
    public static int index = -1;
    public static ArrayAdapter adapterBox;
    public static ListView listViewBox;

    TextView txtId;
    EditText edtName;
    EditText edtDescription;
    EditText edtPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_box);

        txtId =  findViewById(R.id.txtIdActAddEdtBox);
        edtName = findViewById(R.id.edtNameBox);
        edtDescription = findViewById(R.id.edtDescriptionBox);
        edtPrice = findViewById(R.id.edtPriceBox);

        listBox = new ArrayList<>();
        repositoryListBox = new RepositoryListBox();

        adapterBox = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listBox);
        listViewBox = (ListView) findViewById(R.id.ListViewBox);
        listViewBox.setAdapter(adapterBox);
        listViewBox.setSelector(android.R.color.holo_orange_dark);

        listViewBox.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ActivityAddEditBox.this, ""+listBox.get(i).toString(), Toast.LENGTH_SHORT).show();
                index = i;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity_add_edit_box, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.addBox:
                btnAddBox();
                break;
            case R.id.editBox:
                btnEditBox();
                break;
            case R.id.deleteBox:
                btnDeleteBox();
                break;
            case R.id.settingsBox:
                btnSettingsBox();
                break;
            case R.id.aboutBox:
                btnAboutBox();
                break;
        }
        return true;
    }

    public void btnAddBox() {
        String id =  txtId.getText().toString();
        String name = edtName.getText().toString();
        String description = edtDescription.getText().toString();
        String price = edtPrice.getText().toString();

//        intent.putExtra("id", id);
//        intent.putExtra("name", name);
//        intent.putExtra("description", description);
//        intent.putExtra("price", price);

        Box box = new Box(name, description);

        repositoryListBox.setBoxListBox(box);

        adapterBox.clear();

        listBox.addAll(repositoryListBox.getListBox());

        adapterBox.notifyDataSetChanged();
    }

    public void btnEditBox(){
        // TODO: 26/06/2022
    }

    public void btnDeleteBox(){
        // TODO: 26/06/2022
    }

    public void btnSettingsBox(){
        // TODO: 26/06/2022
    }

    public void btnAboutBox(){
        // TODO: 26/06/2022
    }

    public void btnSaveBox(View view) {
        Intent intent = new Intent();
        setResult(clickInSave, intent);
        finish();
        Toast.makeText(ActivityAddEditBox.this, "Alteração Salva", Toast.LENGTH_SHORT).show();
    }

    public void btnCancelBox(View view){
        setResult(clickInCancel);
        finish();
    }
}