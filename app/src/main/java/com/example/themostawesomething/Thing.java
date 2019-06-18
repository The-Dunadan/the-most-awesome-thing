package com.example.themostawesomething;

import android.graphics.drawable.Drawable;
import android.media.Image;

import java.util.ArrayList;
import java.util.List;

public class Thing {
    private int score;
    private int appearances;
    private int name;
    private int image;

    static int[] names = {
            R.string.internet, R.string.life, R.string.universe,
            R.string.cats, R.string.dogs, R.string.android,
            R.string.computers, R.string.semiconductors, R.string.friends,
            R.string.engineering, R.string.medicine, R.string.tacos,
            R.string.snoopy, R.string.hope, R.string.fate,
            R.string.football, R.string.bmw, R.string.music,
            R.string.icecream, R.string.rollercoaster, R.string.paris,
            R.string.breakingbad, R.string.christmas, R.string.jousting
    };

    static int[] images = {
            R.drawable.internet, R.drawable.life, R.drawable.universe,
            R.drawable.cats, R.drawable.dogs, R.drawable.android,
            R.drawable.computers, R.drawable.semiconductors, R.drawable.friends,
            R.drawable.engineering, R.drawable.medicine, R.drawable.tacos,
            R.drawable.snoopy, R.drawable.hope, R.drawable.fate,
            R.drawable.football, R.drawable.bmw, R.drawable.music,
            R.drawable.icecream, R.drawable.rollercoaster, R.drawable.paris,
            R.drawable.breakingbad, R.drawable.christmas, R.drawable.jousting
    };

    public Thing(int name, int image) {
        this.name = name;
        this.image = image;
        score = 0;
        appearances = 0;
    }

    public void incrementScore() {
        ++score;
    }

    public void incrementAppearances() {
        ++appearances;
    }

    // for sorting and stat display
    public float getRatio() {
        return appearances == 0 ? 0 : Math.round(10000 * (float) score / (float) appearances) / (float) 100;
    }

    // creates the list of things using the names and images constants
    public static List<Thing> createList() {
        List<Thing> res = new ArrayList<Thing>();
        for (int i = 0; i < names.length; ++i) {
            res.add(new Thing(names[i], images[i]));
        }
        return res;
    }

    public int getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getImage() {
        return image;
    }
}
