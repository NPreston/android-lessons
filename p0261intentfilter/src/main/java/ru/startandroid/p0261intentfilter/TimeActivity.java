package ru.startandroid.p0261intentfilter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Date;
import java.text.SimpleDateFormat;

public class TimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        SimpleDateFormat formatTime = new SimpleDateFormat("HH.mm.ss");
        String time = formatTime.format(new Date(System.currentTimeMillis()));

        TextView textViewTime = (TextView) findViewById(R.id.viewTime);
        textViewTime.setText(time);
    }
}
