package com.example.dongqiudi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addNews extends AppCompatActivity {
    EditText idt,tit,con;
    Button btn,findbtn;
    DBHelper dbHelper;
    Intent intent;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_news);

        idt = findViewById(R.id.etid);
        tit = findViewById(R.id.ettit);
        con = findViewById(R.id.etcon);
        findbtn = findViewById(R.id.findbtn);
        btn = findViewById(R.id.button);
        dbHelper = new DBHelper(this);
        DBHelper dbHelper = new DBHelper(this);
        database = dbHelper.getReadableDatabase();



        findbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sid = idt.getText().toString();
                queryDataFromDatabase(sid);
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Nid = idt.getText().toString();
                String Tit = tit.getText().toString();
                String Con = con.getText().toString();

                dbHelper.updateNews(Nid,Tit,Con);
                Toast.makeText(addNews.this, "已更新", Toast.LENGTH_SHORT).show();
                intent = new Intent(addNews.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    private void queryDataFromDatabase(String id) {
        String[] projection = {"news_title", "news_context"};
        String selection = "news_id = ?";
        String[] selectionArgs = {id};

        Cursor cursor = database.query("db_news", projection, selection, selectionArgs, null, null, null);
        if (cursor.moveToFirst()) {
            String column2 = cursor.getString(cursor.getColumnIndexOrThrow("news_title"));
            String column3 = cursor.getString(cursor.getColumnIndexOrThrow("news_context"));

            tit.setText(column2);
            con.setText(column3);
        }

        cursor.close();
    }
}
