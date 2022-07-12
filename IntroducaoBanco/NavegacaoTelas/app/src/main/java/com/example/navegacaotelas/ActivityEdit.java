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

import androidx.annotation.NonNull;

import com.example.navegacaotelas.model.Student;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class ActivityEdit extends AppCompatActivity {
    private EditText edtName;
    private EditText edtRegister;
    private EditText edtCPF;
    private TextView txtID;
    private Button btnUpdate;
    private Button btnCancel;
    private Button btnDelete;

    private DatabaseReference defRef;
    private DatabaseReference student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        edtName = findViewById(R.id.edtName);
        edtRegister = findViewById(R.id.edtRegister);
        edtCPF = findViewById(R.id.edtCPF);
        txtID = findViewById(R.id.txtID);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);

        defRef = FirebaseDatabase.getInstance().getReference();
        String studentId = getIntent().getStringExtra("id");
        student = defRef.child("Student").child("studentId");

        student.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()) {
                    edtName.setText(Objects.requireNonNull(dataSnapshot.child("name").getValue().toString()));
                    edtRegister.setText(Objects.requireNonNull(dataSnapshot.child("register").getValue().toString()));
                    edtCPF.setText(Objects.requireNonNull(dataSnapshot.child("cpf").getValue().toString()));
                } else {
                    Toast.makeText(ActivityEdit.this, "Os dados não carregaram", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(edtName.getText().toString())) {
                    Toast.makeText(ActivityEdit.this, "Nome não informado", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(edtRegister.getText().toString())) {
                    Toast.makeText(ActivityEdit.this, "Registro não informado", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(edtCPF.getText().toString())) {
                    Toast.makeText(ActivityEdit.this, "CPF não informado", Toast.LENGTH_SHORT).show();
                } else {
                    Student s = new Student();
                    s.setName(edtName.getText().toString());
                    s.setRegister(edtName.getText().toString());
                    s.setCpf(edtName.getText().toString());
                    student.setValue(s);
                    startActivity(new Intent(ActivityEdit.this, ActivityListStudent.class));
                }


            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                student.removeValue();
                startActivity(new Intent(ActivityEdit.this, ActivityListStudent.class));
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