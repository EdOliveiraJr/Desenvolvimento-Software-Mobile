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

import com.example.projetofinaldsm.model.Order;
import com.example.projetofinaldsm.repository.RepositoryListOrder;

public class ActivityAddEditOrder extends AppCompatActivity {
    public static int clickInSave = 11;
    public static int clickInCancel = 12;

    public static int index = -1;

    public static RepositoryListOrder repositoryListOrder = new RepositoryListOrder();
    public static ArrayAdapter adapterOrder;
    public static ListView listViewOrder;

    TextView txtId;
    EditText edtClientName;
    EditText edtAddress;
    EditText edtObservation;
    EditText edtPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edt_order);

        txtId =  findViewById(R.id.txtId_ActAddEdtOrder);
        edtClientName = findViewById(R.id.edtNameOrder);
        edtAddress = findViewById(R.id.edtAddressOrder);
        edtObservation = findViewById(R.id.edtObservationOrder);
        edtPrice = findViewById(R.id.edtPriceOrder);

        if(getIntent().getExtras() != null){

            int i = (int) getIntent().getExtras().get("index");

            String id = Integer.toString(repositoryListOrder.getListOrder().get(i).getId());
            String client = repositoryListOrder.getListOrder().get(i).getNameClient();
            String address = repositoryListOrder.getListOrder().get(i).getDeliveryAddress();
            String observations = repositoryListOrder.getListOrder().get(i).getObservations();
            String price = Double.toString(repositoryListOrder.getListOrder().get(i).getPrice());

            txtId.setText(id);
            edtClientName.setText(client);
            edtAddress.setText(address);
            edtObservation.setText(observations);
            edtPrice.setText(price);

        }

        adapterOrder = new ArrayAdapter(this, android.R.layout.simple_list_item_1, repositoryListOrder.getListOrder());
        listViewOrder = (ListView) findViewById(R.id.ListViewOrder);
        listViewOrder.setAdapter(adapterOrder);
        listViewOrder.setSelector(android.R.color.holo_orange_dark);

        listViewOrder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ActivityAddEditOrder.this, ""+repositoryListOrder.getListOrder().get(i).toString(), Toast.LENGTH_SHORT).show();
                index = i;

                String id = Integer.toString(repositoryListOrder.getListOrder().get(i).getId());
                String client = repositoryListOrder.getListOrder().get(i).getNameClient();
                String address = repositoryListOrder.getListOrder().get(i).getDeliveryAddress();
                String observations = repositoryListOrder.getListOrder().get(i).getObservations();
                String price = Double.toString(repositoryListOrder.getListOrder().get(i).getPrice());

                txtId.setText(id);
                edtClientName.setText(client);
                edtAddress.setText(address);
                edtObservation.setText(observations);
                edtPrice.setText(price);
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
        String clientName = edtClientName.getText().toString();
        String address = edtAddress.getText().toString();
        String observation = edtObservation.getText().toString();

        Order order = new Order(clientName, address, observation);

        repositoryListOrder.setListOrder(order);

        adapterOrder.notifyDataSetChanged();
    }

    public void btnEditOrder(){
        if(index < 0){
            Toast.makeText(ActivityAddEditOrder.this, "Selecione um pedido para editar", Toast.LENGTH_SHORT).show();
        }else{
            String clientName = edtClientName.getText().toString();
            String address = edtAddress.getText().toString();
            String observation = edtObservation.getText().toString();

            repositoryListOrder.getListOrder().get(index).setNameClient(clientName);
            repositoryListOrder.getListOrder().get(index).setDeliveryAddress(address);
            repositoryListOrder.getListOrder().get(index).setObservations(observation);
            adapterOrder.notifyDataSetChanged();
            index = -1;

        }
    }

    public void btnDeleteOrder(){
        if(index < 0){
            Toast.makeText(ActivityAddEditOrder.this, "Selecione um item para remover", Toast.LENGTH_SHORT).show();
        }else{
            repositoryListOrder.getListOrder().remove(index);
            adapterOrder.notifyDataSetChanged();
            index = -1;
        }
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