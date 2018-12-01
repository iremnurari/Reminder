package com.example.nurir.reminderhomework;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class ListAll extends AppCompatActivity {
    Spinner spinner;
    FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all);
        spinner = findViewById(R.id.listSpinner);
        final ArrayList<String> spinnerList = new ArrayList<>();
        ListView listView = findViewById(R.id.listView);
        floatingActionButton = findViewById(R.id.addnew);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddNewReminderActivity.class);
                startActivity(intent);
            }
        });
        ArrayList<Reminder> reminders = new ArrayList<>();

        reminders.add(new Reminder("başlık","detay","time", "date"));
        reminders.add(new Reminder("başlık2","detay2","time2", "date2"));
        // Create the adapter to convert the array to views
        ReminderListAdapter adapter = new ReminderListAdapter(reminders, this);
        // Attach the adapter to a ListView

        listView.setAdapter(adapter);
        spinnerList.add("Reminder");
        spinnerList.add("Calendar");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, spinnerList);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==1){
                    Intent intent = new Intent(getApplicationContext(), CalendarActivity.class);
                    startActivity(intent);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
