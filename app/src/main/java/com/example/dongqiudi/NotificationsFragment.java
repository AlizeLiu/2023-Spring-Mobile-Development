package com.example.dongqiudi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {
    private ListView RankLv;
    private SQLiteDatabase db;
    private DBHelper dbHelper;
    private Cursor cursor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.notificationsfragment,container,false);
        RankLv = view.findViewById(R.id.RankListView);
        dbHelper = new DBHelper(getActivity());
        db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM db_points", null);
        List<String> dataList = new ArrayList<>();

        dataList.add("排名\t\t\t队名\t\t\t已赛\t\t\t胜\t\t\t平\t\t\t负\t\t\t进球数\t\t\t积分"); // 添加标题行数据

        while (cursor.moveToNext()) {
            String data = cursor.getInt(0) + "\t\t\t\t" + cursor.getString(1)
                    + "\t\t\t\t" + cursor.getInt(2) + "\t\t\t\t" + cursor.getInt(3)
                    + "\t\t\t\t" + cursor.getInt(4) + "\t\t\t\t" + cursor.getInt(5)
                    + "\t\t\t\t" + cursor.getInt(6) + "\t\t\t\t\t" + cursor.getInt(7);
            dataList.add(data);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, dataList);

        RankLv.setAdapter(adapter);
        return view;

    }
}
