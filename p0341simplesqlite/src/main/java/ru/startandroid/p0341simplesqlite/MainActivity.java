package ru.startandroid.p0341simplesqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    EditText editName, editEmail;
    Button btnAdd, btnRead, btnClear;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText) findViewById(R.id.editName);
        editEmail = (EditText) findViewById(R.id.editEmail);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnRead = (Button) findViewById(R.id.btnRead);
        btnClear = (Button) findViewById(R.id.btnClear);

        // создаем объект для создания и управления версиями БД
        dbHelper = new DBHelper(this);
    }

    public void onClickBtnAdd(View view) {
        Log.d(LOG_TAG, "--- Insert: ---");
        // подготовим данные для вставки в виде пар: наименование столбца - значение

        // создаем объект для данных
        ContentValues contentValues = new ContentValues();

        // получаем данные из полей ввода
        String name = editName.getText().toString();
        String email = editEmail.getText().toString();

        contentValues.put(DBHelper.KEY_NAME, name);
        contentValues.put(DBHelper.KEY_EMAIL, email);
        // вставляем запись и получаем ее ID
        long rowID = dbHelper.getWritableDatabase().insert(DBHelper.TABLE_CONTACTS, null, contentValues);
        Log.d(LOG_TAG, "row inserted, ID = " + rowID);

        dbHelper.close();
    }

    public void onClickBtnRead(View view) {
        Log.d(LOG_TAG, "--- Rows: ---");
        // делаем запрос всех данных из таблицы, получаем Cursor
        Cursor cursor = dbHelper.getWritableDatabase().query(DBHelper.TABLE_CONTACTS, null, null, null, null, null, null);

        // ставим позицию курсора на первую строку выборки
        // если в выборке нет строк, вернется false
        if (cursor.moveToFirst()) {

            // определяем номера столбцов по имени в выборке
            int idColIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
            int nameColIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
            int emailColIndex = cursor.getColumnIndex(DBHelper.KEY_EMAIL);

            do {
                // получаем значения по номерам столбцов и пишем все в лог
                Log.d(LOG_TAG,
                        "ID = " + cursor.getInt(idColIndex) +
                                ", name = " + cursor.getString(nameColIndex) +
                                ", email = " + cursor.getString(emailColIndex));
                // переход на следующую строку
                // а если следующей нет (текущая - последняя), то false - выходим из цикла
            } while (cursor.moveToNext());
        } else {
            Log.d(LOG_TAG, "0 rows");
        }

        cursor.close();
        dbHelper.close();
    }

    public void onClickBtnClear(View view) {
        Log.d(LOG_TAG, "--- Clear: ---");
        // удаляем все записи
        int clearCount = dbHelper.getWritableDatabase().delete(DBHelper.TABLE_CONTACTS, null, null);

        Log.d(LOG_TAG, "deleted rows count = " + clearCount);

        dbHelper.close();
    }
}
