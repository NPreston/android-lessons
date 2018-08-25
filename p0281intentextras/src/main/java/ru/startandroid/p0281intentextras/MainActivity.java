package ru.startandroid.p0281intentextras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editFirstName;
    EditText editLastName;

    Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editFirstName = (EditText) findViewById(R.id.etFName);
        editLastName = (EditText) findViewById(R.id.etLName);

        buttonSubmit = (Button) findViewById(R.id.btnSubmit);
        buttonSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, ViewActivity.class);
        intent.putExtra("fname", editFirstName.getText().toString());
        intent.putExtra("lname", editLastName.getText().toString());
        startActivity(intent);
    }
}