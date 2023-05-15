package com.entertainment.client;

import com.entertainment.Television;

class TelevisionClient {

    public static void main(String[] args) {
        // create two Television objects
        Television tv1 = new Television();          // channel 3 by default
        Television tv2 = new Television("RCA", 10); // channel 3 by default

        // show their toString() methods in action
        System.out.println(tv1);
        System.out.println(tv2);

        // change channel on 'tv2' and print - should be on channel 9 now
        tv2.changeChannel(9);
        System.out.println(tv2);
        System.out.println();

        // examine behavior of == and equals()
        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 50);

        System.out.println("tvA == tvB: "      + (tvA == tvB));     // refer to same object?
        System.out.println("tvA.equals(tvB): " + tvA.equals(tvB));  // exhibit "equality"?
    }
}