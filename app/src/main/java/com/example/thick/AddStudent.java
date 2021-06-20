package com.example.thick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class AddStudent extends AppCompatActivity {
    EditText txtName,txtAge;
    Button btnAdd,btnBack;
    StudentDAO studentDAO;
    StudentDatabase studentDatabase;

    String url = "https://60cda85891cc8e00178dbbc0.mockapi.io/Student";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        txtName=findViewById(R.id.txtAddName);
        txtAge=findViewById(R.id.txtAddAge);
        studentDatabase = StudentDatabase.getInstance(getApplicationContext());
        studentDAO = studentDatabase.studentDAO();
        btnAdd = findViewById(R.id.btnThem);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                String age = txtAge.getText().toString();
                Student user = new Student(name,age);
                studentDAO.insertS(user);
                PostApi(url);
                Context context =v.getContext();
                Intent intent  = new Intent(AddStudent.this,Show.class);
                startActivity(intent);
            }
        });
        btnBack = findViewById(R.id.btnBackAdd);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(AddStudent.this,Choose.class);
                startActivity(intent);
            }
        });

    }
    private void PostApi(String url){
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(AddStudent.this, "Successfully", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AddStudent.this, "Error by Post data!", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("name", txtName.getText().toString());
                params.put("age",txtAge.getText().toString());
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}