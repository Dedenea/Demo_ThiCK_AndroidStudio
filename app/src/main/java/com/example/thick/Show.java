package com.example.thick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Show extends AppCompatActivity {
    StudentAdapter studentAdapter;
    StudentDAO studentDAO;
    StudentDatabase studentDatabase;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        studentDatabase = StudentDatabase.getInstance(getApplicationContext());
        studentDAO = studentDatabase.studentDAO();
        initView();

        btnBack = findViewById(R.id.btnBackkkkk);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Show.this,Choose.class);
                startActivity(intent);
            }
        });
    }
    public void initView(){
        RecyclerView recyclerView = findViewById(R.id.rcv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        studentAdapter = new StudentAdapter(studentDAO.getAllS(),getApplicationContext());
        recyclerView.setAdapter(studentAdapter);


    }
}