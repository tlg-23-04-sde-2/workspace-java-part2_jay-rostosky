package com.duckrace;

import java.util.List;

class DuckRacerTest {

    public static void main(String[] args) {
        DuckRacer racer10 = new DuckRacer(10, "Kevin");
        System.out.println(racer10);  // toString() automatically called

        // make it "win" a few times
        racer10.win(Reward.DEBIT_CARD);
        racer10.win(Reward.PRIZES);
        racer10.win(Reward.PRIZES);
        System.out.println(racer10);  // toString() automatically called

        // retrieve a read-only view of the rewards List, add(), remove(), clear() NO GOOD
        List<Reward> rewardsList = racer10.getRewards();
        // rewardsList.add(Reward.DEBIT_CARD);
        // rewardsList.add(Reward.DEBIT_CARD);
        // rewardsList.add(Reward.DEBIT_CARD);

        // show just the rewards
        System.out.println(rewardsList);

        // make it "win" again, and notice how our 'rewardsList' reflects that new Reward
        racer10.win(Reward.PRIZES);

        // the rewards List will reflect this new Reward
        System.out.println(rewardsList);
    }
}