package ru.startandroid.p0181dynamiclayout3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends AppCompatActivity implements OnSeekBarChangeListener {

    SeekBar sbWeight;
    Button btn1;
    Button btn2;

    LinearLayout.LayoutParams lParams1;
    LinearLayout.LayoutParams lParams2;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbWeight = (SeekBar) findViewById(R.id.sbWeight);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        lParams1 = (LinearLayout.LayoutParams) btn1.getLayoutParams();
        lParams2 = (LinearLayout.LayoutParams) btn2.getLayoutParams();

        sbWeight.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int rightValue = seekBar.getMax() - progress;
        // настраиваем вес
        lParams1.weight = progress;
        lParams2.weight = rightValue;
        // в текст кнопок пишем значения переменных
        btn1.setText(String.valueOf(progress));
        btn2.setText(String.valueOf(rightValue));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}