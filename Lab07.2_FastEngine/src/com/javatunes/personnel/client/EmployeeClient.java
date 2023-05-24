package com.javatunes.personnel.client;

import com.fastjava.engine.FastEngine;
import com.javatunes.personnel.Employee;

class EmployeeClient {

    public static void main(String[] args) {
        // initialize the performance engine and register our application classes with it
        FastEngine engine = new FastEngine(Employee.class);  // Class object for Employee
        engine.analyzeClasses();

        // now work with the business classes as usual
        Employee emp = new Employee();
        emp.work();
        emp.pay();
    }
}
