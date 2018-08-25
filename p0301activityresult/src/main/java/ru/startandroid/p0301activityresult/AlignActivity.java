package ru.startandroid.p0301activityresult;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class AlignActivity extends AppCompatActivity {

    Button btnLeft;
    Button btnCenter;
    Button btnRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_align);

        btnLeft = (Button) findViewById(R.id.btnLeft);
        btnCenter = (Button) findViewById(R.id.btnCenter);
        btnRight = (Button) findViewById(R.id.btnRight);
    }

    public void onClickBtnLeft(View view) {
        setIntentAndFinish(Gravity.LEFT);
    }

    public void onClickBtnCenter(View view) {
        setIntentAndFinish(Gravity.CENTER);
    }

    public void onClickBtnRight(View view) {
        setIntentAndFinish(Gravity.RIGHT);
    }

    private void setIntentAndFinish(int align) {
        Intent intent = new Intent();
        intent.putExtra("alignment", align);

        setResult(RESULT_OK, intent);
        finish();
    }
}
