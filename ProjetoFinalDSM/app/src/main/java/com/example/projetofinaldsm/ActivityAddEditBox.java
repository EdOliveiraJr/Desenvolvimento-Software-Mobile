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
    public static int clickInSave = 8;
    public static int clickInCancel = 9;
    public static int clickInAddItemBox = 10;
    public static boolean viewBox = true;

    public static int index = -1;

    public static RepositoryListBox  repositoryListBox = new RepositoryListBox();;
    public static ArrayAdapter adapterBox;
    public static ArrayAdapter adapterItem;
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

        if(getIntent().getExtras() != null){

            int i = (int) getIntent().getExtras().get("index");

            String id = Integer.toString(repositoryListBox.getListBox().get(i).getId());
            String name = repositoryListBox.getListBox().get(i).getName();
            String description = repositoryListBox.getListBox().get(i).getDescription();
            String price = Double.toString(repositoryListBox.getListBox().get(i).getPrice());

            txtId.setText(id);
            edtName.setText(name);
            edtDescription.setText(description);
            edtPrice.setText(price);

        }

        adapterBox = new ArrayAdapter(this, android.R.layout.simple_list_item_1, repositoryListBox.getListBox());
        adapterItem = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ActivityAddEditItem.repositoryListItem.getListItem());
        listViewBox = (ListView) findViewById(R.id.ListViewBox);
        listViewBox.setAdapter(adapterBox);
        listViewBox.setSelector(android.R.color.holo_orange_dark);

        listViewBox.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ActivityAddEditBox.this, ""+repositoryListBox.getListBox().get(i).toString(), Toast.LENGTH_SHORT).show();
                index = i;

                String id = Integer.toString(repositoryListBox.getListBox().get(i).getId());
                String name = repositoryListBox.getListBox().get(i).getName();
                String description = repositoryListBox.getListBox().get(i).getDescription();
                String price = Double.toString(repositoryListBox.getListBox().get(i).getPrice());

                txtId.setText(id);
                edtName.setText(name);
                edtDescription.setText(description);
                edtPrice.setText(price);
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
        String name = edtName.getText().toString();
        String description = edtDescription.getText().toString();

        Box box = new Box(name, description);

        repositoryListBox.setBoxListBox(box);

        adapterBox.notifyDataSetChanged();
    }

    public void btnEditBox(){
        if(index < 0){
            Toast.makeText(ActivityAddEditBox.this, "Selecione um item para editar", Toast.LENGTH_SHORT).show();
        }else{
            String name = edtName.getText().toString();
            String description = edtDescription.getText().toString();

            repositoryListBox.getListBox().get(index).setName(name);
            repositoryListBox.getListBox().get(index).setDescription(description);
            adapterBox.notifyDataSetChanged();
            index = -1;
        }
    }

    public void btnDeleteBox(){
        if(index < 0){
            Toast.makeText(ActivityAddEditBox.this, "Selecione uma box para remover", Toast.LENGTH_SHORT).show();
        }else{
            repositoryListBox.getListBox().remove(index);
            adapterBox.notifyDataSetChanged();
            index = -1;
        }
    }

    public void btnSettingsBox(){
        // TODO: 26/06/2022
    }

    public void btnAboutBox(){
        Intent intent = new Intent(this, ActivityAbout.class);
        startActivity(intent);

    }

    public void btnSaveBox(View view) {
        Intent intent = new Intent();
        setResult(clickInSave, intent);
        finish();
        Toast.makeText(ActivityAddEditBox.this, "Alteração Salva", Toast.LENGTH_SHORT).show();
    }

    public void btnAddItemBox(View view){
        String ii = (String) txtId.getText();
        int i = Integer.parseInt(ii);

        if(viewBox == true){
            Toast.makeText(ActivityAddEditBox.this, "Selecione uma Box e depois o Item que deseja adicionar", Toast.LENGTH_LONG).show();
        }else{
            repositoryListBox.getListBox().get(i).setItemBox(ActivityAddEditItem.repositoryListItem.getListItem().get(index));
        }
    }

    public void btnViewListBox(View view){
        viewBox = true;
        listViewBox.setAdapter(adapterBox);
        listViewBox.setSelector(android.R.color.holo_orange_dark);

        listViewBox.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ActivityAddEditBox.this, ""+repositoryListBox.getListBox().get(i).toString(), Toast.LENGTH_SHORT).show();
                index = i;

                String id = Integer.toString(repositoryListBox.getListBox().get(i).getId());
                String name = repositoryListBox.getListBox().get(i).getName();
                String description = repositoryListBox.getListBox().get(i).getDescription();
                String price = Double.toString(repositoryListBox.getListBox().get(i).getPrice());

                txtId.setText(id);
                edtName.setText(name);
                edtDescription.setText(description);
                edtPrice.setText(price);
            }
        });
    }

    public void btnViewListItem(View view){
        viewBox = false;
        listViewBox.setAdapter(adapterItem);
        listViewBox.setSelector(android.R.color.holo_orange_dark);

        listViewBox.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ActivityAddEditBox.this, ""+ActivityAddEditItem.repositoryListItem.getListItem().get(i).toString(), Toast.LENGTH_SHORT).show();
                index = i;
            }
        });
    }

    public void btnCancelBox(View view){
        setResult(clickInCancel);
        finish();
    }
}