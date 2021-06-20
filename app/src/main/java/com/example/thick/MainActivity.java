package com.example.thick;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText email, pass;
    Button login;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fAuth=FirebaseAuth.getInstance();
        email=findViewById(R.id.txtEmail);
        pass=findViewById(R.id.txtPass);
        login=findViewById(R.id.btnLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e,p;
                e=email.getText().toString();
                p=pass.getText().toString();
                if(TextUtils.isEmpty(e)){
                    Toast.makeText(getApplicationContext(),"Chưa nhập mật Email!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(p)){
                    Toast.makeText(getApplicationContext(),"Chưa nhập mật Password!",Toast.LENGTH_SHORT).show();
                    return;
                }
                fAuth.signInWithEmailAndPassword(e,p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Đăng nhập thành công!",Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(MainActivity.this,Choose.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(getApplicationContext(),"Đăng nhập không thành công!",Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                });
            }
        });
    }
}