package com.example.convertmilestokm;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.text.DecimalFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button buttonPink, buttonBlue, buttonSpecial, buttonGoTo, buttonMusic, buttonGoToChgB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonBlue = findViewById(R.id.buttonBlue);
        buttonPink = findViewById(R.id.buttonPink);
        buttonSpecial = new Button(getApplicationContext());
        buttonSpecial.setTextColor(Color.BLACK);
        buttonSpecial.setBackgroundColor(Color.parseColor("#fd9bf3"));
        buttonSpecial.setText("do some stuff");
        buttonSpecial.setOnClickListener(this::toDo);
        ConstraintLayout l = findViewById(R.id.main);
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        l.addView(buttonSpecial, params);

        buttonGoTo = findViewById(R.id.buttonGoTo);
        buttonGoTo.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),
                    ListActivity.class);

            startActivity(intent);
        });

        buttonMusic = findViewById(R.id.buttonMusic);
        buttonMusic.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),
                    MusicActivity.class);

            startActivity(intent);
        });

        buttonGoToChgB = findViewById(R.id.btnGoToChgBckg);
        buttonGoToChgB.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),
                    BackgroundActivity.class);

            startActivity(intent);
        });

        Button buttonGoToImg = findViewById(R.id.buttonGoToImg);
        buttonGoToImg.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),
                    ImageActivity.class);

            startActivity(intent);
        });


        Button buttonConvMilesToKm = findViewById(R.id.buttonConvMilesToKm);
        buttonConvMilesToKm.setOnClickListener(view -> {
            EditText tbMiles = findViewById(R.id.editTextMiles);
            EditText tbKm = findViewById(R.id.editTextKm);
            double miles = Double.valueOf(tbMiles.getText().toString());
            double km = miles / 0.62137;
            DecimalFormat fmt = (DecimalFormat) DecimalFormat.getInstance(Locale.ENGLISH);
            fmt.applyPattern("##.##");
            tbKm.setText(fmt.format(km));
        });

        Button buttonConvKmToMiles = findViewById(R.id.buttonConvKmToMiles);
        buttonConvKmToMiles.setOnClickListener(view -> {
            EditText tbMiles = findViewById(R.id.editTextMiles);
            EditText tbKm = findViewById(R.id.editTextKm);
            double km = Double.valueOf(tbKm.getText().toString());
            double miles = km * 0.62137;
            DecimalFormat fmt = (DecimalFormat) DecimalFormat.getInstance(Locale.ENGLISH);
            fmt.applyPattern("##.##");
            tbMiles.setText(fmt.format(miles));
        });
    }

    public void toDo(View v) {
        if (v.equals(buttonBlue)) {
            //invisibility
            v.setVisibility(View.INVISIBLE);
        }
        if (v.equals(buttonPink)) {
            //popup
            Toast.makeText(getApplicationContext(), "Yeah", Toast.LENGTH_LONG).show();
        }
        if (v.equals(buttonSpecial)) {
            //popup
            Toast.makeText(getApplicationContext(), "SPECIAAAL !!!!", Toast.LENGTH_SHORT).show();
        }
    }


}