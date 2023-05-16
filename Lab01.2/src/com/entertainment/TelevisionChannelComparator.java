package com.entertainment;

import java.util.Comparator;

public class TelevisionChannelComparator implements Comparator<Television> {

    @Override
    public int compare(Television tv1, Television tv2) {
        /*
         * For primitive sort keys, use the appropriate wrapper class:
         *  Integer.compare() for ints
         *  Double.compare()  for doubles
         *  Long.compare()    for longs
         *  Boolean.compare() for booleans
         */
        return Integer.compare(tv1.getCurrentChannel(), tv2.getCurrentChannel());
    }
}