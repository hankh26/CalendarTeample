package com.hh1995.myapplication.calendarteam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Alarm extends AppCompatActivity {

    private ArrayList<AlarmMainData> arrayList;
    private AlarmMainAdapter mainAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private String Schedule_date;
    private String Schedule_time;
    private String scheduleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        recyclerView = (RecyclerView)findViewById(R.id.rv);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();

        mainAdapter = new AlarmMainAdapter(arrayList);
        recyclerView.setAdapter(mainAdapter);

        Button btn_add = (Button)findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDatePicker();


            }
        });
    }

    public void showDatePicker() {
        DialogFragment newFragment = new AlarmDatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");

    }


    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (year_string+"년  "+month_string +"월  "+day_string+"일  ");
        Schedule_date = dateMessage;
        // Toast.makeText(this, "Date"+dateMessage,Toast.LENGTH_SHORT).show();

        showTimePicker();

    }

    public void showTimePicker() {
        DialogFragment newFragment = new AlarmTimePickerFragment();
        newFragment.show(getSupportFragmentManager(),"timePicker");
    }

    public void precessTimePickerResult(int hour, int minute) {
        String hour_string = Integer.toString(hour);
        String minute_string = Integer.toString(minute);
        String TimeMessage = (hour_string + "시 " + minute_string+"분");
        Schedule_time = TimeMessage;

        // Toast.makeText(this, "Time"+TimeMessage, Toast.LENGTH_SHORT).show();
        // addAlarmList();

        showInputSchedule();


    }

    public void showInputSchedule() {

        AlertDialog.Builder Input_Schedule = new AlertDialog.Builder(Alarm.this);

        Input_Schedule.setTitle("일정");

        final EditText et_schedule = new EditText(Alarm.this);
        Input_Schedule.setView(et_schedule);

        Input_Schedule.setPositiveButton("완료", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                scheduleText = et_schedule.getText().toString();

                addAlarmList();
            }
        });

        Input_Schedule.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });

        Input_Schedule.show();

    }


    public void addAlarmList() {
        AlarmMainData mainData = new AlarmMainData(Schedule_date +"      "+ Schedule_time, scheduleText);
        arrayList.add(mainData);
        mainAdapter.notifyDataSetChanged();
    }

}