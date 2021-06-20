package com.example.thick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Choose extends AppCompatActivity {
    Button btnBackM,btnShow,btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        btnShow=findViewById(R.id.btnShow);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choose.this,Show.class);
                startActivity(intent);
            }
        });
        btnAdd=findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choose.this,AddStudent.class);
                startActivity(intent);
            }
        });
        btnBackM=findViewById(R.id.btnBackM);
        btnBackM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choose.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}