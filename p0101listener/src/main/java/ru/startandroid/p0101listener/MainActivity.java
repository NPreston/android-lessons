package ru.startandroid.p0101listener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvOut;
    Button btnOk;
    Button btnCancel;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // найдем View-элементы
        tvOut = (TextView) findViewById(R.id.tvOut);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        // создание обработчика
        OnClickListener oclBtn = new OnClickListener() {
            @Override
            public void onClick(View v) {
                // по id определеяем кнопку, вызвавшую этот обработчик
                switch (v.getId()) {
                    case R.id.btnOk:
                        // кнопка ОК
                        tvOut.setText("Нажата кнопка ОК");
                        break;
                    case R.id.btnCancel:
                        // кнопка Cancel
                        tvOut.setText("Нажата кнопка Cancel");
                        break;
                }
            }
        };

        btnOk.setOnClickListener(oclBtn);
        btnCancel.setOnClickListener(oclBtn);
    }
}
