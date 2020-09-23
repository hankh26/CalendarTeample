package com.hh1995.myapplication.calendarteam;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class AlarmTimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {


    @NonNull
    @Override
    public Dialog onCreateDialog(@NonNull Bundle savedInstanceState) {
        final Calendar calendarT = Calendar.getInstance();
        int hour = calendarT.get(Calendar.HOUR_OF_DAY);
        int minute = calendarT.get(Calendar.MINUTE);


        return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));

    }

    @Override
    public void onTimeSet(TimePicker view, int hour, int minute) {
        Alarm alarm = (Alarm) getActivity();
        alarm.precessTimePickerResult(hour, minute);


    }
}