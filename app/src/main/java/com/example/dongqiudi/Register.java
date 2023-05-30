package com.example.dongqiudi;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    private DBHelper dbHelper;
    private EditText Re_etId,Re_etpasswd;
    private Button Register;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Re_etId = findViewById(R.id.Re_etUserID);
        Re_etpasswd = findViewById(R.id.Re_etUserPasswd);
        Register = findViewById(R.id.register);
        dbHelper = new DBHelper(this);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username = Re_etId.getText().toString();
                String Passwd = Re_etpasswd.getText().toString();

                long result = dbHelper.addUser(Username, Passwd);
                if(result != -1){
                    Toast.makeText(Register.this, "亲爱的用户，恭喜你注册成功", Toast.LENGTH_SHORT).show();
                    intent = new Intent(com.example.dongqiudi.Register.this,Login.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Register.this, "注册失败，请一分钟后重试", Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
}