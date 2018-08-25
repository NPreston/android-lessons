package ru.startandroid.p0271getintentaction;

import android.content.Intent;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent intent = getIntent();
        String action = intent.getAction();

        String format = "";
        String textInfo = "";

        if (action.equals("ru.startandroid.intent.action.showtime")) {
            format = "HH:mm:ss";
            textInfo = "Time:";
        } else if (action.equals("ru.startandroid.intent.action.showdate")) {
            format = "dd:MM:yyyy";
            textInfo = "Date:";
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        String dateTime = simpleDateFormat.format(new Date(System.currentTimeMillis()));

        TextView tvDate = (TextView) findViewById(R.id.textView);
        tvDate.setText(String.format("%s %s", textInfo, dateTime));
    }
}
