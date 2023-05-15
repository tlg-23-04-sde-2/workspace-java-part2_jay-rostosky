package com.entertainment.client;

import com.entertainment.Television;
import java.util.HashSet;
import java.util.Set;

class TelevisionClient {

    public static void main(String[] args) {
        // examine behavior of == and equals()
        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 50);

        System.out.println("tvA == tvB: "      + (tvA == tvB));     // refer to same object?
        System.out.println("tvA.equals(tvB): " + tvA.equals(tvB));  // exhibit "equality"?
        System.out.println();

        System.out.println(tvA.hashCode());
        System.out.println(tvB.hashCode());

        Set<Television> tvs = new HashSet<>();
        tvs.add(tvA);
        tvs.add(tvB);  // should be rejected as a duplicate, and size is still 1
        System.out.println("The size of the Set is: " + tvs.size());
    }
}