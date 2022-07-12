package com.example.navegacaotelas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navegacaotelas.model.Student;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityAdd extends AppCompatActivity {
    private EditText edtName;
    private EditText edtRegister;
    private EditText edtCPF;
    private TextView txtID;
    private Button btnSave;
    private Button btnCancel;


    private DatabaseReference defRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        edtName = findViewById(R.id.edtName);
        edtRegister = findViewById(R.id.edtRegister);
        edtCPF = findViewById(R.id.edtCPF);
        txtID = findViewById(R.id.txtID);
        btnSave = findViewById(R.id.btnUpdate);
        btnCancel = findViewById(R.id.btnCancel);

        defRef = FirebaseDatabase.getInstance().getReference();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (TextUtils.isEmpty(edtName.getText().toString())) {
                        Toast.makeText(ActivityAdd.this, "Nome não informado", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(edtRegister.getText().toString())) {
                        Toast.makeText(ActivityAdd.this, "Registro não informado", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(edtCPF.getText().toString())) {
                        Toast.makeText(ActivityAdd.this, "CPF não informado", Toast.LENGTH_SHORT).show();
                    } else {
                        Student student = new Student();
                        student.setName(edtName.getText().toString());
                        student.setRegister(edtRegister.getText().toString());
                        student.setCpf(edtCPF.getText().toString());
                        defRef.child("Student").child(Integer.toString(student.getId())).setValue(student);
                        startActivity(new Intent(ActivityAdd.this, ActivityListStudent.class));
                    }
                } catch (Exception e) {
                    Toast.makeText(ActivityAdd.this, "Não foi possível cadastrar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}