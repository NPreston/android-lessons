package ru.startandroid.p0201simpleanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.view.MenuItem;
import android.view.ContextMenu;
import android.view.animation.AnimationUtils;
import android.view.ContextMenu.ContextMenuInfo;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);

        registerForContextMenu(tv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        // TODO Auto-generated method stub
        getMenuInflater().inflate(R.menu.animations_menu, menu);
    }

    public void onAlphaItemClick(MenuItem item) {
        animateTextView(R.anim.myalpha);
    }

    public void onScaleItemClick(MenuItem item) {
        animateTextView(R.anim.myscale);
    }

    public void onTranslateItemClick(MenuItem item) {
        animateTextView(R.anim.mytrans);
    }

    public void onRotateItemClick(MenuItem item) {
        animateTextView(R.anim.myrotate);
    }

    public void onComboItemClick(MenuItem item) {
        animateTextView(R.anim.mycombo);
    }

    private void animateTextView(int animation) {
        tv.startAnimation(AnimationUtils.loadAnimation(this, animation));
    }
}