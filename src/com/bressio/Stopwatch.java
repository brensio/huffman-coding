package com.bressio;

public class Stopwatch {

    private long start;

    public Stopwatch() {
        start = System.nanoTime();
    }

    public void stop(String msg) {
        StringOut.printFootnote(msg + " " + String.valueOf((System.nanoTime() - start) / 1000000) + "ms");
    }
}
