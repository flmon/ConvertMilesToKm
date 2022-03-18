package com.example.convertmilestokm;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class BackgroundActivity extends AppCompatActivity implements View.OnClickListener {
    RadioButton btnBlue, btnMagenta, btnYellow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background);

        btnBlue = findViewById(R.id.radioButtonBlue);
        btnBlue.setOnClickListener(this);
        btnMagenta = findViewById(R.id.radioButtonMagenta);
        btnMagenta.setOnClickListener(this);
        btnYellow = findViewById(R.id.radioButtonYellow);
        btnYellow.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        ConstraintLayout layout = findViewById(R.id.layout);
        switch (view.getId()) {
            case R.id.radioButtonBlue:
                layout.setBackgroundColor(Color.BLUE);
                break;
            case R.id.radioButtonMagenta:
                layout.setBackgroundColor(Color.MAGENTA);
                break;
            case R.id.radioButtonYellow:
                layout.setBackgroundColor(Color.YELLOW);
                break;
        }

    }
}