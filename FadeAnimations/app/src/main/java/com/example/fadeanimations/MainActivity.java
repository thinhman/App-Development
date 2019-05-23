package com.example.fadeanimations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void fade(View view) {
        ImageView bart = (ImageView) findViewById(R.id.bart);
        //ImageView homer = (ImageView) findViewById(R.id.homer);
        //bart.animate().translationXBy(1000f).setDuration(2000);
        //bart.animate().rotation(180f).setDuration(2000);
        bart.animate().scaleX(0.5f).scaleY(0.5f).setDuration(2000);
        /*if(bart.getAlpha() == 1f)
        {
            bart.animate().alpha(0f).setDuration(2000);
            homer.animate().alpha(1f).setDuration(2000);
        }
        else
        {
            homer.animate().alpha(0f).setDuration(2000);
            bart.animate().alpha(1f).setDuration(2000);
        }*/
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView bart = (ImageView) findViewById(R.id.bart);
        //bart.setTranslationX(-1000f);

    }


}
