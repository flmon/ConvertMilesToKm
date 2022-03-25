package com.example.convertmilestokm;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.NumberPicker;

import androidx.appcompat.app.AppCompatActivity;

public class WebActivity extends AppCompatActivity {
    NumberPicker np;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        np = findViewById(R.id.numberPicker);
        String[] possStr = {"Android", "Checklist text-input field", "Coursera", "Supélec"};
        np.setDisplayedValues(possStr);
        np.setMinValue(0);
        np.setMaxValue(possStr.length - 1);
    }

    public void navigate(View v) {
        int choice = np.getValue();
        WebView wv = findViewById(R.id.webView);
        wv.setWebViewClient(new WebViewClient());
        if (choice == 0)
            wv.loadUrl("file:///android_asset/android.html");
        else if (choice == 1) wv.loadUrl("file:///android_asset/checklist.html");
        else if (choice == 2) wv.loadUrl("http://www.coursera.org");
        else if (choice == 3) wv.loadUrl("file:///android_asset/supelec.html");
    }
}