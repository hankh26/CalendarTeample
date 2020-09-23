package com.hh1995.myapplication.calendarteam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class TodoActivity extends AppCompatActivity {
    //데이터베이스에서 받을 것. 더미데이터
    private final String[] mMemoArr = { "재고 100원 빔", "책팔기", "샴푸사기", "오전 미팅"};
    private final int REQUEST_GOTOMEMO = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        //달력으로부터 date를 받아야함.
//        Intent intent = getIntent();
//         final int date = intent.getExtras().getInt("data");

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.list_memo_item, R.id.tv_memoItem, mMemoArr);
        ListView listView = findViewById(R.id.lv_todo_memo);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intentToMemo = new Intent(getApplicationContext(), MemoActivity.class);
                intentToMemo.putExtra("position", i);
                //intentToMemo.putExtra("date", date);
                startActivity(intentToMemo);
            }
        });

        //근무시간 표시
        final Spinner spStartHour =findViewById(R.id.sp_todo_workStart);
        final Spinner spEndHour =findViewById(R.id.sp_todo_workEnd);
        final TextView tvHour = findViewById(R.id.tv_todo_sumHour);

        spStartHour.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int hour = spEndHour.getSelectedItemPosition() - spStartHour.getSelectedItemPosition();
                tvHour.setText(Math.max(hour, 0) + "시간");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spEndHour.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int hour = spEndHour.getSelectedItemPosition() - spStartHour.getSelectedItemPosition();
                tvHour.setText(Math.max(hour, 0) + "시간");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }
}