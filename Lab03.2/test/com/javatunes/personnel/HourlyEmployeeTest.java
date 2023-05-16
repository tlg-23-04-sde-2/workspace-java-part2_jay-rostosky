package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;
import java.sql.Date;
import static org.junit.Assert.*;

public class HourlyEmployeeTest {
    // business object under test - called a "fixture"
    private HourlyEmployee emp;

    @Before
    public void setUp() {
        emp = new HourlyEmployee("James", Date.valueOf("2000-11-11"), 25.0, 30.0);
    }

    @Test
    public void testPay() {
        assertEquals(750.0, emp.pay(), .001);  // expected, actual, delta
    }

    @Test
    public void testPayTaxes() {
        assertEquals(187.5, emp.payTaxes(), .001);  // 25% of the rate * hours
    }
}