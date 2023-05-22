package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;
import java.sql.Date;
import static org.junit.Assert.*;

public class EmployeeTest {
    // business objects under test
    private Employee emp1;
    private Employee emp2;

    @Before
    public void setUp() {
        emp1 = getEmployee();
        emp2 = getEmployee();

        // emp1 = new DummyEmployee("John", Date.valueOf("2000-01-01"));
        // emp2 = new DummyEmployee("John", Date.valueOf("2000-01-01"));
    }

    private Employee getEmployee() {
        return new Employee("John", Date.valueOf("2000-01-01")) {
            public double pay() { return 0; }
            public double payTaxes() { return 0; }
        };
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate() {
        emp2.setName("DIFFERENT");

        assertNotEquals(emp1, emp2);
        assertFalse(emp1.equals(emp2));
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate() {
        emp2.setHireDate(Date.valueOf("2001-10-10"));

        assertNotEquals(emp1, emp2);
        assertFalse(emp1.equals(emp2));
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(emp1, emp2);  // does an equals() check for objects
        assertTrue(emp1.equals(emp2));  // alternative assertion
    }

    // MEMBER-LEVEL NAMED INNER CLASSES
    private class DummyEmployee extends Employee {

        public DummyEmployee(String name, Date hireDate) {
            super(name, hireDate);
        }

        @Override
        public double pay() {
            return 0;
        }

        @Override
        public double payTaxes() {
            return 0;
        }
    }
}