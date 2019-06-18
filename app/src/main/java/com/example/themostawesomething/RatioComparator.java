package com.example.themostawesomething;

import java.util.Comparator;

public class RatioComparator implements Comparator<Thing> {
    @Override
    public int compare(Thing o1, Thing o2) {
        if (o1.getRatio() < o2.getRatio()) {
            return 1;
        } else if (o1.getRatio() > o2.getRatio()) {
            return -1;
        }
        return o2.getScore() - o1.getScore();
    }
}
