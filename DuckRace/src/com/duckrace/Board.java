package com.duckrace;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * This is a lookup table of ids to student names.
 * When a duck wins for the first time, we need to find out who that is.
 * This lookup table could be hardcoded with the data, or we could read the data 
 * in from a file, so that no code changes would need to be made for each cohort.
 *
 * Map<Integer,String> studentIdMap;
 * 
 * Integer    String
 * =======    ======
 *    1       John
 *    2       Jane
 *    3       Danny
 *    4       Armando
 *    5       Sheila
 *    6       Tess
 * 
 *
 * We also need a data structure to hold the results of all winners.
 * This data structure should facilitate easy lookup, retrieval, and storage.
 *
 * Map<Integer,DuckRacer> racerMap;
 *
 * Integer    DuckRacer
 * =======    =========
 *            id    name     wins   rewards
 *            --    ----     ----   -------
 *    5        5    Sheila     2    PRIZES, PRIZES
 *    6        6    Tess       1    PRIZES
 *   13       13    Zed        3    PRIZES, DEBIT_CARD, DEBIT_CARD
 *   17       17    Dom        1    DEBIT_CARD
 */

class Board {
    private final Map<Integer,String> studentIdMap = loadStudentIdMap();
    private final Map<Integer,DuckRacer> racerMap  = new TreeMap<>();

    /*
     * Updates the board (racerMap) by making a DuckRacer "win."
     * This could mean fetching an existing DuckRacer from racerMap,
     * or we might need to create a new DuckRacer and put in the map.
     * Either way, we need to make it "win."
     */
    public void update(int id, Reward reward) {
        DuckRacer racer = null;

        if (racerMap.containsKey(id)) {  // id exists in racerMap, so get DuckRacer next to it
            racer = racerMap.get(id);
        }
        else {                           // id not present, create new DuckRacer, put it in map
            racer = new DuckRacer(id, studentIdMap.get(id));  // id, name
            racerMap.put(id, racer);     // easy to forget this step
        }
        racer.win(reward);
    }

    // show the DuckRacers (only), i.e., the right side of the map
    // TODO: render this data "pretty," for display to the end user
    // See Java Part 1 Session 5 Formatted Output
    public void show() {
        Collection<DuckRacer> racers = racerMap.values();

        StringBuilder display = new StringBuilder();
        display.append("Duck Race Results\n");
        display.append("=================\n");
        display.append("\n");
        display.append("id    name      wins    rewards\n");
        display.append("--    ----      ----    -------\n");

        for (DuckRacer racer : racers) {
            String rewardsString = racer.getRewards().toString();
            String rewards = rewardsString.substring(1, rewardsString.length() - 1);

            String row = String.format("%2d    %-8s %4d     %s\n",
                    racer.getId(), racer.getName(), racer.getWins(), rewards);
            display.append(row);
        }
        System.out.println(display);
    }

    private Map<Integer,String> loadStudentIdMap() {
        Map<Integer,String> idMap = new HashMap<>();

        // read all lines from conf/student-ids.csv
        try {
            List<String> lines = Files.readAllLines(Path.of("conf/student-ids.csv"));

            // for each line (String) in the file, split it into "tokens"
            // convert the tokens as necessary and put each pair in 'idMap'
            for (String line : lines) {
                String[] tokens = line.split(",");  // ["1", "Bullen"]
                idMap.put(Integer.valueOf(tokens[0]), tokens[1]);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return idMap;
    }
}