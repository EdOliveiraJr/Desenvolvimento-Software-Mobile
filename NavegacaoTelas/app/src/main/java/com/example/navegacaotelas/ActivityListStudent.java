package com.example.navegacaotelas;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navegacaotelas.model.Student;

import java.util.ArrayList;

public class ActivityListStudent extends AppCompatActivity {

    public static int request_add = 1;
    public static int request_edit = 2;

    public static int index;
    public static ArrayList<Student> listStudent;
    public static ArrayAdapter adapter;
    public static ListView listview;

    TextView txtIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_student);

        txtIndex = (TextView) findViewById(R.id.edtIndex);
        txtIndex.setText("");
        index = -1;

        listStudent = new ArrayList<>();

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listStudent);
        listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter);
        listview.setSelector(android.R.color.holo_orange_dark);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ActivityListStudent.this, ""+listStudent.get(i).toString(), Toast.LENGTH_SHORT).show();
                index = i;
                txtIndex.setText("Identificador: "+listStudent.get(i).getId() +
                        " Nome: "+listStudent.get(i).getName().toString());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == request_add && resultCode == ActivityEditList.result_save){
            if(data.getExtras() != null){
                String name = (String) data.getExtras().get("name");
                String register = (String) data.getExtras().get("register");
                String cpf = (String) data.getExtras().get("cpf");

                listStudent.add(new Student(name, register, cpf, listStudent.size()+1));

                adapter.notifyDataSetChanged();

                txtIndex.setText("");
                index = -1;
            }
        }else if(requestCode == request_edit && resultCode == ActivityEditList.result_save){
            if(data.getExtras() != null){
                String name = (String) data.getExtras().get("name");
                String register = (String) data.getExtras().get("register");
                String cpf = (String) data.getExtras().get("cpf");
                String id = (String) data.getExtras().get("id");
                index = Integer.parseInt(id)-1;

                listStudent.add(index, new Student(name,register,cpf, index+1));
                listStudent.remove(index+1);

                adapter.notifyDataSetChanged();

                txtIndex.setText("");
                index = -1;
            }
        }else{
            Toast.makeText(this, "Alteração cancelada",Toast.LENGTH_SHORT).show();
        }
    }

    public void clickBtnAdd(View view) {
        Intent intent = new Intent(this, ActivityEditList.class);
        startActivityForResult(intent, request_add);
    }

    public void clickBtnEdt(View view) {
        if(index == -1){
            Toast.makeText(ActivityListStudent.this, "Selecione um aluno para editar", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this, ActivityEditList.class);

            int i = listStudent.get(index).getId();
            String name = listStudent.get(index).getName();
            String register = listStudent.get(index).getRegister();
            String cpf = listStudent.get(index).getCpf();
            String id = Integer.toString(i);

            intent.putExtra("name", name);
            intent.putExtra("register", register);
            intent.putExtra("cpf", cpf);
            intent.putExtra("id", id);

            startActivityForResult(intent, request_edit);

        }
    }
}

