package ru.startandroid.p0261intentfilter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        SimpleDateFormat formatTime = new SimpleDateFormat("EEE, MMM d, yyyy");
        String date = formatTime.format(new Date(System.currentTimeMillis()));

        TextView textViewDate = (TextView) findViewById(R.id.viewDate);
        textViewDate.setText(date);
    }
}
