package ru.startandroid.p0301activityresult;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ColorActivity extends AppCompatActivity {

    Button btnRed;
    Button btnGreen;
    Button btnBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        btnRed = (Button) findViewById(R.id.btnRed);
        btnGreen = (Button) findViewById(R.id.btnGreen);
        btnBlue = (Button) findViewById(R.id.btnBlue);
    }

    public void onClickBtnRed(View view) {
        setIntentAndFinish(Color.RED);
    }

    public void onClickBtnGreen(View view) {
        setIntentAndFinish(Color.GREEN);
    }

    public void onClickBtnBlue(View view) {
        setIntentAndFinish(Color.BLUE);
    }

    private void setIntentAndFinish(int color) {
        Intent intent = new Intent();
        intent.putExtra("color", color);

        setResult(RESULT_OK, intent);
        finish();
    }
}