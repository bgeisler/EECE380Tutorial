package com.tutorialapp.eece380.tutorial1;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class Activity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);
        Intent intent = getIntent();
        String message = intent.getStringExtra("Extra_Message");
        TextView t = (TextView)findViewById(R.id.textview1);
        t.setText(message);
    }
}
