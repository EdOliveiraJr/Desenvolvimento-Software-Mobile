package com.example.navegacaotelas;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navegacaotelas.model.Student;

import java.util.ArrayList;

public class ActivityEditList extends AppCompatActivity {
    public static int result_save = 1;
    public static int result_cancel = 2;

    EditText edtName;
    EditText edtRegister;
    EditText edtCPF;
    TextView txtID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_list);

        edtName = findViewById(R.id.edtName);
        edtRegister = findViewById(R.id.edtRegister);
        edtCPF = findViewById(R.id.edtCPF);
        txtID = findViewById(R.id.txtID);

        if(getIntent().getExtras() != null){
            String name = (String) getIntent().getExtras().get("name");
            String register = (String) getIntent().getExtras().get("register");
            String cpf = (String) getIntent().getExtras().get("cpf");
            String id = (String) getIntent().getExtras().get("id");

            edtName.setText(name);
            edtRegister.setText(register);
            edtCPF.setText(cpf);
            txtID.setText(id);

        }

    }


    public void clickBtnSave(View view){

        Intent intent = new Intent();

        String name = edtName.getText().toString();
        String register = edtRegister.getText().toString();
        String cpf = edtCPF.getText().toString();
        String id =  txtID.getText().toString();

        intent.putExtra("name", name);
        intent.putExtra("register", register);
        intent.putExtra("cpf", cpf);
        intent.putExtra("id", id);

        setResult(result_save, intent);
        finish();
        Toast.makeText(ActivityEditList.this, "Alteração Salva", Toast.LENGTH_SHORT).show();
    }


    public void clickBtnCancel(View view){
        setResult(result_cancel);
        finish();
    }


}