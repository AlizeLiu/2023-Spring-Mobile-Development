package com.example.dongqiudi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addNews extends AppCompatActivity {
    EditText id,tit,con;
    Button btn;
    DBHelper dbHelper;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_news);

        id = findViewById(R.id.etid);
        tit = findViewById(R.id.ettit);
        con = findViewById(R.id.etcon);

        btn = findViewById(R.id.button);
        dbHelper = new DBHelper(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Nid = id.getText().toString();
                String Tit = tit.getText().toString();
                String Con = con.getText().toString();

                dbHelper.updateNews(Nid,Tit,Con);
                Toast.makeText(addNews.this, "已更新", Toast.LENGTH_SHORT).show();
                intent = new Intent(addNews.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}