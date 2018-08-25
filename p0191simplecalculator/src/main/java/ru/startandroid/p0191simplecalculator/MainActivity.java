package ru.startandroid.p0191simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static ru.startandroid.p0191simplecalculator.R.id.quite;
import static ru.startandroid.p0191simplecalculator.R.id.reset;

public class MainActivity extends AppCompatActivity {

    EditText etNum1;
    EditText etNum2;

    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;

    TextView tvResult;

    String oper = "";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // находим элементы
        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);

        tvResult = (TextView) findViewById(R.id.tvResult);
    }

    public void onSumBtnClick(View view) {
        oper = "+";
        printResult();
    }

    public void onSubBtnClick(View view) {
        oper = "-";
        printResult();
    }

    public void onMultBtnClick(View view) {
        oper = "*";
        printResult();
    }

    public void onDivBtnClick(View view) {
        oper = "/";
        printResult();
    }

    public void printResult() {
        if (TextUtils.isEmpty(etNum1.getText().toString()) || TextUtils.isEmpty(etNum2.getText().toString())) {
            return;
        }

        float num1 = Float.parseFloat(etNum1.getText().toString());
        float num2 = Float.parseFloat(etNum2.getText().toString());

        if (num2 == 0 && oper.equals("/")) {
            Toast.makeText(this, "Деление на ноль невозможно", Toast.LENGTH_SHORT).show();
            return;
        }

        float result = 0;

        switch (oper) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                break;
        }

        tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
    }

    // создание меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // обработка нажатий на пункты меню
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.reset:
                // очищаем поля
                etNum1.setText("");
                etNum2.setText("");
                tvResult.setText("");
                break;
            case R.id.quite:
                // выход из приложения
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}