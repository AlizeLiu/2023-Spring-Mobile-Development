package com.example.dongqiudi;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private EditText etID,etPasswd;
    private Button Register,Login;
    private Intent intent;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Register = findViewById(R.id.register);
        Login = findViewById(R.id.Login);
        dbHelper = new DBHelper(this);
        etID = findViewById(R.id.etUserID);
        etPasswd = findViewById(R.id.etUserPasswd);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Login.this, com.example.dongqiudi.Register.class);
                startActivity(intent);
            }
        });
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username = etID.getText().toString();
                String Passwd = etPasswd.getText().toString();

                if(dbHelper.checkUser(Username,Passwd)){
                    Toast.makeText(Login.this, "登录成功", Toast.LENGTH_SHORT).show();
                    intent = new Intent(Login.this,MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Login.this,"账号密码错误",Toast.LENGTH_SHORT).show();
                }





            }
        });

    }
}