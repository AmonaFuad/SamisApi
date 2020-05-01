package com.example.android.samisapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    Bundle extras;
    String newString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        extras =getIntent().getExtras();
        newString=extras.getString("EXTRA_MESSAGE");
        TextView textView=(TextView)findViewById(R.id.videoTest);
        textView.setText(newString);

    }
}
