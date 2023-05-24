package com.fastjava.engine;

import com.fastjava.annotation.Fast;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * This is the runtime performance engine.
 * FastJava-enabled applications that run on this engine will see a performance boost,
 * configured by their use of our @Fast annotation.
 */
public class FastEngine {
    private Collection<Class<?>> classes = new ArrayList<>();

    public FastEngine(Class<?>... classes) {
        Collections.addAll(this.classes, classes);
    }

    public void analyzeClasses() {
        for (Class<?> klass : classes) {
            Fast fastAnnotation = klass.getAnnotation(Fast.class);
            System.out.println("\n- - - - - - F A S T   J A V A   P E R F O R M A N C E   R E P O R T - - - - - -");

            reportClassLevel(klass, fastAnnotation);
            System.out.println();

            reportMethodLevel(klass);
            System.out.println("- - - - - - - - - (c) FastJava, Inc.  All Rights Reserved - - - - - - - - - - -");
        }
    }

    private void reportMethodLevel(Class<?> klass) {
        Method[] methods = klass.getDeclaredMethods();
        for (Method method : methods) {
            Fast fastAnnotation = method.getAnnotation(Fast.class);
            if (fastAnnotation != null) {
                double boostFactor = fastAnnotation.value();
                boolean log = fastAnnotation.log();
                String description = fastAnnotation.description();
                System.out.println("The method '" + method.getName() + "' has boost set to " + boostFactor);
                System.out.println("The boost is being logged: " + log);
                System.out.println("The boost description: " + description);
            }
        }
    }

    private void reportClassLevel(Class<?> klass, Fast fastAnnotation) {
        System.out.println("The @Fast annotation has been declared on class " + klass.getName());

        double boostFactor = fastAnnotation.value();
        boolean log = fastAnnotation.log();
        String description = fastAnnotation.description();

        System.out.println("The class-level default performance boost is set to " + boostFactor);
        System.out.println("The boost is being logged: " + log);
        System.out.println("The boost description: " + description);
    }
}