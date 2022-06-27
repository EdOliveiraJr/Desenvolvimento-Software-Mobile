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
import com.example.projetofinaldsm.model.Order;
import com.example.projetofinaldsm.repository.RepositoryListOrder;

import java.util.ArrayList;

public class ActivityAddEditOrder extends AppCompatActivity {
    public static int clickInSave = 8;
    public static int clickInCancel = 9;

    public static RepositoryListOrder repositoryListOrder;
    public static ArrayList<Order> listOrder;
    public static int index = -1;
    public static ArrayAdapter adapterOrder;
    public static ListView listViewOrder;

    TextView txtId;
    EditText edtCLientName;
    EditText edtAddress;
    EditText edtObservation;
    EditText edtPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edt_order);

        repositoryListOrder = new RepositoryListOrder();

        txtId =  findViewById(R.id.txtId_ActAddEdtOrder);
        edtCLientName = findViewById(R.id.edtNameOrder);
        edtAddress = findViewById(R.id.edtAddressOrder);
        edtObservation = findViewById(R.id.edtObservationOrder);
        edtPrice = findViewById(R.id.edtPriceBox);

        listOrder = new ArrayList<>();
        repositoryListOrder = new RepositoryListOrder();

        adapterOrder = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listOrder);
        listViewOrder = (ListView) findViewById(R.id.ListViewOrder);
        listViewOrder.setAdapter(adapterOrder);
        listViewOrder.setSelector(android.R.color.holo_orange_dark);

        listViewOrder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ActivityAddEditOrder.this, ""+listOrder.get(i).toString(), Toast.LENGTH_SHORT).show();
                index = i;
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity_add_edit_order, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.addOrder:
                btnAddOrder();
                break;
            case R.id.editOrder:
                btnEditOrder();
                break;
            case R.id.deleteOrder:
                btnDeleteOrder();
                break;
            case R.id.settingsOrder:
                btnSettingsOrder();
                break;
            case R.id.aboutOrder:
                btnAboutOrder();
                break;
        }
        return true;
    }

    public void btnAddOrder() {
        String id =  txtId.getText().toString();
        String clientName = edtCLientName.getText().toString();
        String address = edtAddress.getText().toString();
        String observation = edtObservation.getText().toString();

//        intent.putExtra("id", id);
//        intent.putExtra("name", name);
//        intent.putExtra("description", description);
//        intent.putExtra("price", price);

        Order order = new Order(clientName, address, observation);

        repositoryListOrder.setBoxListOrder(order);

        adapterOrder.clear();

        listOrder.addAll(repositoryListOrder.getListOrder());

        adapterOrder.notifyDataSetChanged();
    }

    public void btnEditOrder(){
        // TODO: 26/06/2022
    }

    public void btnDeleteOrder(){
        // TODO: 26/06/2022
    }

    public void btnSettingsOrder(){
        // TODO: 26/06/2022
    }

    public void btnAboutOrder(){
        Intent intent = new Intent(this, ActivityAbout.class);
        startActivity(intent);

    }

    public void btnSaveOrder(View view) {
        Intent intent = new Intent();
        setResult(clickInSave, intent);
        finish();
        Toast.makeText(ActivityAddEditOrder.this, "Alteração Salva", Toast.LENGTH_SHORT).show();
    }

    public void btnCancelOrder(View view){
        setResult(clickInCancel);
        finish();
    }
}