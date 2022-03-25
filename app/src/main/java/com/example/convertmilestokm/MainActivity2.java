package com.example.convertmilestokm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent caller = getIntent();
        float rating = caller.getFloatExtra("nbStars", 0);
        TextView tv = findViewById(R.id.textView2);
        tv.setText(rating + " nb stars");

        Button btn = findViewById(R.id.buttonSend);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = ((EditText) findViewById(R.id.editTextMsg)).getText().toString();
                Uri destination = Uri.parse("smsto:0764014624");
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, destination);
                smsIntent.putExtra("sms_body", msg);
                startActivity(smsIntent);
            }
        });
    }
}