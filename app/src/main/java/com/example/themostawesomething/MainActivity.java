package com.example.themostawesomething;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Thing> things = Thing.createList();
    Button button1;
    TextView text1;
    Button button2;
    TextView text2;
    Button stats_button;
    Button quit_button;
    int idx1, idx2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializations
        button1 = findViewById(R.id.button1);
        text1 = findViewById(R.id.text1);
        button2 = findViewById(R.id.button2);
        text2 = findViewById(R.id.text2);
        stats_button = findViewById(R.id.stats_button);
        quit_button = findViewById(R.id.quit_button);

        initChoices();
        text1.setMovementMethod(LinkMovementMethod.getInstance());
        text2.setMovementMethod(LinkMovementMethod.getInstance());

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                things.get(idx1).incrementScore();
                initChoices();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                things.get(idx2).incrementScore();
                initChoices();
            }
        });
        // sort things; open new activity
        stats_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(things, new RatioComparator());
                Intent intent = new Intent(MainActivity.this, StatsActivity.class);
                intent.putExtra("text", statsPrint());
                startActivity(intent);
            }
        });
        // system exit
        quit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }

    // Associate a Thing to each button
    public void initChoices() {
        do {
            idx1 = getRandomIndex(things.size());
            idx2 = getRandomIndex(things.size());
        } while (idx1 == idx2);

        things.get(idx1).incrementAppearances();
        things.get(idx2).incrementAppearances();

        button1.setBackground(getResources().getDrawable(things.get(idx1).getImage()));
        text1.setText(Html.fromHtml(getResources().getString(things.get(idx1).getName())));
        button2.setBackground(getResources().getDrawable(things.get(idx2).getImage()));
        text2.setText(Html.fromHtml(getResources().getString(things.get(idx2).getName())));
    }

    public int getRandomIndex(int range) {
        double randomDouble = Math.random();
        randomDouble *= range;
        return (int)randomDouble;
    }

    // pretty print for stats
    public String statsPrint() {
        StringBuffer stats = new StringBuffer();
        for (int i = 0; i < things.size(); ++i) {
            float ratio = things.get(i).getRatio();
            stats.append((i + 1) + ". "
                    + Html.fromHtml(getResources().getString(things.get(i).getName()))
                    + " (" + ratio + "%)\n");
        }
        return stats.toString();
    }
}
