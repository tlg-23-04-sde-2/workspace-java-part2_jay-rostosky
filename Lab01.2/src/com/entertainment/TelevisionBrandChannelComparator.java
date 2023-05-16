package com.entertainment;

import java.util.Comparator;

public class TelevisionBrandChannelComparator implements Comparator<Television> {

    @Override
    public int compare(Television tv1, Television tv2) {
        // first we compare brand (String)
        int result = tv1.getBrand().compareTo(tv2.getBrand());

        // if result is 0, we're tied on brand, so break the tie by comparing channel
        if (result == 0) {
            result = Integer.compare(tv1.getCurrentChannel(), tv2.getCurrentChannel());
        }
        return result;
    }
}