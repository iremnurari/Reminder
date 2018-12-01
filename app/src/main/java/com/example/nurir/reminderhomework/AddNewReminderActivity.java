package com.example.nurir.reminderhomework;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AddNewReminderActivity extends AppCompatActivity {
    Button timeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_reminder);
        timeButton = (Button) findViewById(R.id.timeButton);
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                TimePicker popTime = new TimePicker();
                popTime.show(fragmentManager,"as");
            }
        });

    }
    public void setTime(String time){
        Toast.makeText(getApplicationContext(), time, Toast.LENGTH_LONG).show();
    }
}
