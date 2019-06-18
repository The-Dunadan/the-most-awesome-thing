package com.example.themostawesomething;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Thing> {
    @Override
    public int compare(Thing o1, Thing o2) {
        return o2.getScore() - o1.getScore();
    }
}
