package com.example.themostawesomething;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class StatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        Bundle bundle = getIntent().getExtras();
        String stats = bundle.getString("text");
        TextView stats_body = findViewById(R.id.stats_body);
        stats_body.setText(stats);
        stats_body.setMovementMethod(new ScrollingMovementMethod());
    }
}
