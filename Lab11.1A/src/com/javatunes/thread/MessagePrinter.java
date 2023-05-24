package com.javatunes.thread;

public class MessagePrinter extends Thread {
    private static final String threadNamePrefix = "message-printer-";
    private static int id = 0;

    private final String message;
    private int count = 10;
    private long interval = 1000;

    public MessagePrinter(String message) {
        this.message = message;
        setName(threadNamePrefix + ++id);
    }

    public MessagePrinter(String message, int count, long interval) {
        this(message);
        this.count = count;
        this.interval = interval;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println(getName() + ": " + message);

            try {
                Thread.sleep(interval);
            }
            catch (InterruptedException ignored) {
            }
        }
    }
}