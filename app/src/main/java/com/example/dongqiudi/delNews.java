package com.example.dongqiudi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class delNews extends AppCompatActivity {
    Button btn;
    DBHelper dbHelper;
    Intent intent;
    EditText etID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_del_news);

        btn = findViewById(R.id.button2);
        dbHelper = new DBHelper(this);
        etID = findViewById(R.id.etNo);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Did = etID.getText().toString();

                dbHelper.deleteNews(Did);
                Toast.makeText(delNews.this, "已删除", Toast.LENGTH_SHORT).show();
                intent = new Intent(delNews.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}