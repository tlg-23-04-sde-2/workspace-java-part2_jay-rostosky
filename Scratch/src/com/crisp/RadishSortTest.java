package com.crisp;

import java.util.ArrayList;
import java.util.List;

class RadishSortTest {

    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<>();

        // color, size, tailLength, guysOnTop
        radishes.add(new Radish("red",    1.0,  2.2, 3));
        radishes.add(new Radish("black",  3.5,  0.0, 0));
        radishes.add(new Radish("red",    0.75, 3.1, 7));
        radishes.add(new Radish("white",  1.0,  1.0, 2));

        radishes.sort(null);  // passing null means natural order
        System.out.println("Natural order (size)");
        dump(radishes);
        System.out.println();

        radishes.sort(new RadishColorComparator());
        System.out.println("Color");
        dump(radishes);
    }

    private static void dump(List<Radish> radishList) {
        for (Radish radish : radishList) {
            System.out.println(radish);
        }
    }
}