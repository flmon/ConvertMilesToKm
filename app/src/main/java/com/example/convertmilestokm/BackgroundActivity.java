package com.example.convertmilestokm;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class BackgroundActivity extends AppCompatActivity {
    static String COLOR_PREF = "COLOR_PREF";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background);

        SharedPreferences pref = getSharedPreferences(COLOR_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        RadioGroup rg = findViewById(R.id.rbgroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                ConstraintLayout layout = findViewById(R.id.layout);
                int colorCode = 0;
                switch (i) {
                    case R.id.radioButtonBlue:
                        colorCode = Color.BLUE;
                        break;
                    case R.id.radioButtonMagenta:
                        colorCode = Color.MAGENTA;
                        break;
                    case R.id.radioButtonYellow:
                        colorCode = Color.YELLOW;
                        break;
                }
                layout.setBackgroundColor(colorCode);
                editor.putInt(COLOR_PREF, colorCode);
                editor.commit();
            }
        });
    }

}