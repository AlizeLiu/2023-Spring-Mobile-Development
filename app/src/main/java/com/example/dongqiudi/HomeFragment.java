package com.example.dongqiudi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private ListView newsLv;
    private SQLiteDatabase db;
    private DBHelper dbHelper;
    private Cursor cursor;
    //private Button upBtn,delBtn;
    private Intent intent;
    private ImageButton btn1,btn2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homefragment, container, false);
        newsLv = view.findViewById(R.id.newsListView);
        dbHelper = new DBHelper(getActivity());
        db = dbHelper.getReadableDatabase();
        //upBtn = view.findViewById(R.id.upNews);
        //delBtn = view.findViewById(R.id.delBtn);
        btn1 = view.findViewById(R.id.update);
        btn2 = view.findViewById(R.id.delte);
        cursor = db.rawQuery("SELECT news_title,news_context FROM db_news", null);
        List<String> dataList = new ArrayList<>();
        while (cursor.moveToNext()) {
            String data = cursor.getString(0) + " \n\t\t" + cursor.getString(1); // 数据为字符串类型
            dataList.add(data);
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, dataList);
        newsLv.setAdapter(adapter);

        newsLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cursor.moveToPosition(position);
                String newsTitle = cursor.getString(0);
                String newsContext = cursor.getString(1);

                Intent intent = new Intent(getContext(), itemClick.class);
                intent.putExtra("newsTitle", newsTitle);
                intent.putExtra("newsContext", newsContext);
                startActivity(intent);
            }
        });



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getContext(),addNews.class);

                startActivity(intent);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getContext(),delNews.class);
                startActivity(intent);

            }
        });
                return view;
            }
        }
