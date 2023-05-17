package com.entertainment;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TelevisionChannelComparatorTest {
    private Television tv1;
    private Television tv2;
    private TelevisionChannelComparator comparator;

    @Before
    public void setUp() {
        tv1 = new Television();  // channel 3 by default
        tv2 = new Television();  // channel 3 by default

        // also need to create the "independent agent," "neutral 3rd party" piece
        comparator = new TelevisionChannelComparator();
    }

    @Test
    public void compare_shouldReturnZero_whenSameChannel() {
        assertEquals(0, comparator.compare(tv1, tv2));
    }

    @Test
    public void compare_shouldReturnNegativeNumber_when1stChannelLessThan2ndChannel()
    throws InvalidChannelException {
        tv1.changeChannel(1);
        assertTrue(comparator.compare(tv1, tv2) < 0);
    }

    @Test
    public void compare_shouldReturnPositiveNumber_when1stChannelGreaterThan2ndChannel()
    throws InvalidChannelException {
        tv1.changeChannel(999);
        assertTrue(comparator.compare(tv1, tv2) > 0);
    }
}