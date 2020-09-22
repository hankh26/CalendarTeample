package com.hh1995.myapplication.calendarteam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TodoActivity extends AppCompatActivity {
    //데이터베이스에서 받을 것. 더미데이터
    private final String[] mMemoArr = { "재고 100원 빔", "책팔기", "샴푸사기", "오전 미팅"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.list_memo_item, R.id.tv_memoItem, mMemoArr);
        ListView listView = findViewById(R.id.lv_memo);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
}