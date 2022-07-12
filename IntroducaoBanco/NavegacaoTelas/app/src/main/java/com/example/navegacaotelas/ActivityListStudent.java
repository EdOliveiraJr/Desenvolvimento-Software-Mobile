package com.example.navegacaotelas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.navegacaotelas.model.Student;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ActivityListStudent extends AppCompatActivity {

    public static ArrayList<Student> listStudent = new ArrayList<>();
    public static ArrayAdapter adapter;
    public static ListView listview;

    private Button btnAdd;

    private DatabaseReference defRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_student);

        btnAdd = findViewById(R.id.btnAdd);

        defRef = FirebaseDatabase.getInstance().getReference();

        defRef.child("Student").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listStudent.clear();
                for (DataSnapshot objSnapshot : dataSnapshot.getChildren()) {
                    Student student = objSnapshot.getValue(Student.class);
                    listStudent.add(student);
                }
                adapter = new ArrayAdapter(ActivityListStudent.this, android.R.layout.simple_list_item_1, listStudent);
                listview = (ListView) findViewById(R.id.listview);
                listview.setAdapter(adapter);
                listview.setSelector(android.R.color.holo_orange_dark);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityListStudent.this, ActivityEdit.class);
                startActivity(intent);
            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ActivityListStudent.this, "" + listStudent.get(i).toString(), Toast.LENGTH_SHORT).show();
                Student student = (Student) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(ActivityListStudent.this, ActivityEdit.class);
                intent.putExtra("id", student.getId());
                startActivity(intent);
            }
        });
    }
}

