package com.colin;

public class Game {

    private String STARTING_TIME = "7:00";

    private Clock clock = new Clock(STARTING_TIME);

    public Game() {
    }

    public Clock getClock() {
        return clock;
    }
}
