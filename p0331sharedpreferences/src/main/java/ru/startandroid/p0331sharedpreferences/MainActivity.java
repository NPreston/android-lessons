package ru.startandroid.p0331sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String SAVED_TEXT = "saved_text";

    EditText editText;
    Button btnSave;
    Button btnLoad;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnLoad = (Button) findViewById(R.id.btnLoad);

        loadText();
    }

    public void saveText() {
        preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(SAVED_TEXT, editText.getText().toString());
        editor.apply();

        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }

    public void loadText() {
        preferences = getPreferences(MODE_PRIVATE);
        String savedText = preferences.getString(SAVED_TEXT, "");
        editText.setText(savedText);

        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText();
    }
}
