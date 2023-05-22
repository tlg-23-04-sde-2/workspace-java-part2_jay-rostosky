package com.duckrace.client;

import com.duckrace.app.DuckRaceApp;

/*
 * Gets the application going, and that's it.
 */
class Main {

    public static void main(String[] args) {
        // instantiate controller and say "go"
        DuckRaceApp app = new DuckRaceApp();
        app.execute();
    }
}