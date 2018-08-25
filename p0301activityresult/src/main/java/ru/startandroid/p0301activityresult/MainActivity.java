package ru.startandroid.p0301activityresult;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int REQUEST_CODE_COLOR = 1;
    final int REQUEST_CODE_ALIGN = 2;

    TextView tvText;
    Button btnColor;
    Button btnAlign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvText = (TextView) findViewById(R.id.tvText);
        btnColor = (Button) findViewById(R.id.btnColor);
        btnAlign = (Button) findViewById(R.id.btnAlign);
    }

    public void onClickChangeColor(View view) {
        setIntentAndFinish(ColorActivity.class, REQUEST_CODE_COLOR);
    }

    public void onClickChangeAlign(View view) {
        setIntentAndFinish(AlignActivity.class, REQUEST_CODE_ALIGN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("myLogs", String.format("requestCode = %s, resultCode = %s", requestCode, resultCode));

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_COLOR:
                    int color = data.getIntExtra("color", Color.WHITE);
                    tvText.setTextColor(color);
                    break;
                case REQUEST_CODE_ALIGN:
                    int align = data.getIntExtra("alignment", Gravity.LEFT);
                    tvText.setGravity(align);
                    break;
            }
        } else {
            Toast.makeText(this, "Wrong result", Toast.LENGTH_SHORT).show();
        }
    }

    private void setIntentAndFinish(Class<?> className, int requestCode) {
        Intent intent = new Intent(this, className);
        startActivityForResult(intent, requestCode);
    }
}