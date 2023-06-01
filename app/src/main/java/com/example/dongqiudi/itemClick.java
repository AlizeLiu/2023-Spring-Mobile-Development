package com.example.dongqiudi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class itemClick extends AppCompatActivity {
    TextView title,context;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_click);

        title = findViewById(R.id.titleTextView);
        context = findViewById(R.id.contextTextView);

        intent = getIntent();
        String newsTitle = intent.getStringExtra("newsTitle");
        String newsContext = intent.getStringExtra("newsContext");

        title.setText(newsTitle);
        context.setText(newsContext);

    }
}