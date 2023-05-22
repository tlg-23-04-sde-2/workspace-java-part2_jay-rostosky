package com.duckrace;

class BoardTest {

    public static void main(String[] args) {
        // create a Board object, which initializes its fields, causing the file to get read
        Board board = new Board();

        // update the Board a few times, each time requires an id and a reward
        board.update(3,  Reward.PRIZES);
        board.update(3,  Reward.DEBIT_CARD);
        board.update(10, Reward.DEBIT_CARD);
        board.update(13, Reward.DEBIT_CARD);
        board.update(1,  Reward.PRIZES);
        board.update(5,  Reward.DEBIT_CARD);
        board.update(3,  Reward.DEBIT_CARD);
        board.update(13, Reward.DEBIT_CARD);
        board.show();
    }
}