package com.javatunes.thread;

public class MessagePrinterClient {

    public static void main(String[] args) {
        // 30 secs total
        MessagePrinter printer1 = new MessagePrinter("roses are red", 10, 3000);
        printer1.start();

        // 20 secs total
        MessagePrinter printer2 = new MessagePrinter("violets are blue", 100, 200);
        printer2.start();

        // 10 times (default), 1 second each (default) = 10 secs
        MessagePrinter printer3 = new MessagePrinter("sugar is sweet");
        printer3.start();

        // 32 secs
        MessagePrinter printer4 = new MessagePrinter("actually, sugar is TOXIC", 16, 2000);
        printer4.start();
    }
}