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

import com.example.projetofinaldsm.model.Item;
import com.example.projetofinaldsm.repository.RepositoryListItem;

import java.util.ArrayList;

public class ActivityAddEditItem extends AppCompatActivity {
    public static int clickInSave = 6;
    public static int clickInCancel = 7;

    public static int index = -1;

    public static RepositoryListItem repositoryListItem = new RepositoryListItem();
    public static ListView listViewItem;
    public static ArrayAdapter adapterItem;

    EditText edtName;
    EditText edtDescription;
    EditText edtPrice;
    TextView txtID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_item);

        txtID = findViewById(R.id.txtId_ActAddEdtItem);
        edtName = findViewById(R.id.edtNameItem);
        edtDescription = findViewById(R.id.edtDescriptionItem);
        edtPrice = findViewById(R.id.edtPriceItem);

        txtID.setText("");

        if(getIntent().getExtras() != null){

            int i = (int) getIntent().getExtras().get("index");

            String id = Integer.toString(repositoryListItem.getListItem().get(i).getId());
            String name = repositoryListItem.getListItem().get(i).getName();
            String description = repositoryListItem.getListItem().get(i).getDescription();
            String price = Double.toString(repositoryListItem.getListItem().get(i).getPrice());

            txtID.setText(id);
            edtName.setText(name);
            edtDescription.setText(description);
            edtPrice.setText(price);

        }

        adapterItem = new ArrayAdapter(this, android.R.layout.simple_list_item_1, repositoryListItem.getListItem());
        listViewItem = (ListView) findViewById(R.id.ListViewItem);
        listViewItem.setAdapter(adapterItem);
        listViewItem.setSelector(android.R.color.holo_orange_dark);

        listViewItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ActivityAddEditItem.this, ""+repositoryListItem.getListItem().get(i).toString() + "ind: " + i, Toast.LENGTH_SHORT).show();
                index = i;

                String id = Integer.toString(repositoryListItem.getListItem().get(i).getId());
                String name = repositoryListItem.getListItem().get(i).getName();
                String description = repositoryListItem.getListItem().get(i).getDescription();
                String price = Double.toString(repositoryListItem.getListItem().get(i).getPrice());

                txtID.setText(id);
                edtName.setText(name);
                edtDescription.setText(description);
                edtPrice.setText(price);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity_add_edit_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.addItem:
                btnAddItem();
                break;
            case R.id.editItem:
                btnEditItem();
                break;
            case R.id.deleteItem:
                btnDeleteItem();
                break;
            case R.id.settingsItem:
                btnSettingsItem();
                break;
            case R.id.aboutItem:
                btnAboutItem();
                break;
        }
        return true;
    }

    public void btnAddItem(){
        String name = edtName.getText().toString();
        String description = edtDescription.getText().toString();
        String price = edtPrice.getText().toString();

        Item item = new Item(name, description, Double.parseDouble(price));
        repositoryListItem.setItemLisItem(item);
        adapterItem.notifyDataSetChanged();
    }

    public void btnEditItem(){
        if(index < 0) {
            Toast.makeText(ActivityAddEditItem.this, "Selecione um item para editar", Toast.LENGTH_SHORT).show();
        }else{
            String name = edtName.getText().toString();
            String description = edtDescription.getText().toString();
            String price = edtPrice.getText().toString();

            repositoryListItem.getListItem().get(index).setNome(name);
            repositoryListItem.getListItem().get(index).setDescription(description);
            repositoryListItem.getListItem().get(index).setPrice(Double.parseDouble(price));
            adapterItem.notifyDataSetChanged();
            index = -1;
        }

    }

    public void btnDeleteItem(){
        if(index < 0){
            Toast.makeText(ActivityAddEditItem.this, "Selecione um item para remover", Toast.LENGTH_SHORT).show();
        }else{
            repositoryListItem.getListItem().remove(index);
            adapterItem.notifyDataSetChanged();
            index = -1;
        }
    }

    public void btnSettingsItem(){
        // TODO: 26/06/2022
    }

    public void btnAboutItem(){
        Intent intent = new Intent(this, ActivityAbout.class);
        startActivity(intent);

    }

    public void btnSaveItem(View view){
        Intent intent = new Intent();
        setResult(clickInSave, intent);
        finish();
        Toast.makeText(ActivityAddEditItem.this, "Alteração Salva", Toast.LENGTH_SHORT).show();

    }

    public void btnCancelItem(View view){
        setResult(clickInCancel);
        finish();
    }

}