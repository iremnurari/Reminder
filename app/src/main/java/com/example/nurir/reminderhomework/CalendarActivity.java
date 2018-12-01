package com.example.nurir.reminderhomework;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class CalendarActivity extends AppCompatActivity {
    CalendarView calendarView ;
    Spinner spinner;
    TextView myDate;
    FloatingActionButton fab ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        spinner = findViewById(R.id.calenderSpinner);
        final ArrayList<String> spinnerList = new ArrayList<>();

        spinnerList.add("Reminder");
        spinnerList.add("Calendar");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, spinnerList);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(arrayAdapter);
        spinner.setSelection(1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent intent = new Intent(getApplicationContext(), ListAll.class);
                    startActivity(intent);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        myDate = (TextView) findViewById(R.id.myDate);
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = year+ "/" +month+ "/" +dayOfMonth;
                myDate.setText(date);
            }
        });

    }
}
