package ru.startandroid.p0291simpleactivityresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editTextName;
    Button buttonOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        editTextName = (EditText) findViewById(R.id.etName);
        buttonOk = (Button) findViewById(R.id.btnOK);
        buttonOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("name", editTextName.getText().toString());
        setResult(RESULT_OK, intent);

        finish();
    }
}
