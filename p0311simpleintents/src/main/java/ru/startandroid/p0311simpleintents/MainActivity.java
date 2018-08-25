package ru.startandroid.p0311simpleintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnWeb;
    Button btnMap;
    Button btnCall;

    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWeb = (Button) findViewById(R.id.btnWeb);
        btnMap = (Button) findViewById(R.id.btnMap);
        btnCall = (Button) findViewById(R.id.btnCall);
    }

    public void onClickWebBtn(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.android.com"));
        startActivity(intent);
    }

    public void onClickMapBtn(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_EDIT);
        intent.setData(Uri.parse("geo:51.754111283,37.620332354202"));
        startActivity(intent);
    }

    public void onClickMapCall(View view) {
        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setData(Uri.parse("tel:12345"));
        startActivity(intent);
    }
}
