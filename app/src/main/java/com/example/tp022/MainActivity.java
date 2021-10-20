package com.example.tp022;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int  mcount = 0 ;
    private TextView textcount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textcount = (TextView) findViewById(R.id.textcount);

        if (savedInstanceState != null) {
            boolean isVisible =
                    savedInstanceState.getBoolean("reply_visible");

            if (isVisible) {
                textcount.setVisibility(View.VISIBLE);
                textcount.setText(savedInstanceState.getString("reply_text"));
            }
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (textcount.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text", textcount.getText().toString());
        }

    }

    public void count (View v){
        ++mcount;
        if (textcount != null)
            textcount.setText(Integer.toString(mcount));

    }
}