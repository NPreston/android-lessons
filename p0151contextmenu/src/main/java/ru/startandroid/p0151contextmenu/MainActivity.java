package ru.startandroid.p0151contextmenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.view.ContextMenu.ContextMenuInfo;

public class MainActivity extends AppCompatActivity {

    TextView tvColor;
    TextView tvSize;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvColor = (TextView) findViewById(R.id.tvColor);
        tvSize = (TextView) findViewById(R.id.tvSize);

        // для tvColor и tvSize необходимо создавать контекстное меню
        registerForContextMenu(tvColor);
        registerForContextMenu(tvSize);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        // TODO Auto-generated method stub
        Integer layout = v.getId() == R.id.tvColor ? R.menu.color_menu : R.menu.size_menu;
        getMenuInflater().inflate(layout, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            // пункты меню для tvColor
           /* case R.id.menu_red:
                tvColor.setTextColor(Color.RED);
                tvColor.setText("Text color = red");
                break;*/
            case R.id.menu_green:
                tvColor.setTextColor(Color.GREEN);
                tvColor.setText("Text color = green");
                break;
            case R.id.menu_blue:
                tvColor.setTextColor(Color.BLUE);
                tvColor.setText("Text color = blue");
                break;
            case R.id.menu_yellow:
                tvColor.setTextColor(Color.YELLOW);
                tvColor.setText("Text color = yellow");
                break;
            // пункты меню для tvSize
            case R.id.menu_small_size:
                tvSize.setTextSize(22);
                tvSize.setText("Text size = 22");
                break;
            case R.id.menu_middle_size:
                tvSize.setTextSize(26);
                tvSize.setText("Text size = 26");
                break;
            case R.id.menu_large_size:
                tvSize.setTextSize(30);
                tvSize.setText("Text size = 30");
                break;
        }
        return super.onContextItemSelected(item);
    }

    public void  onRedItemClick(MenuItem item) {
        tvColor.setTextColor(Color.RED);
        tvColor.setText("Text color = red");
    }
}
