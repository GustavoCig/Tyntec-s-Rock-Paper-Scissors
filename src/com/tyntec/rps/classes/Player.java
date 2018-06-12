package com.tyntec.rps.classes;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import static com.tyntec.rps.classes.Moves.getMoveByIndex;


public class Player {

    private static final AtomicInteger count =  new AtomicInteger(1);

    private Moves play;
    private int wins, loses;
    private int id;

    public Player(Moves chosen) {
        this.setPlay(chosen);
        this.setWins(0);
        this.setLoses(0);
        this.setId(count.getAndIncrement());
    }

    public Player() {
        this.setRandomPlay();
        this.setWins(0);
        this.setLoses(0);
        this.setId(count.getAndIncrement());
    }

    public int getId() {
        return this.id;
    }

    public void setId(int newId) {
        this.id = newId;
    }

    public Moves getPlay() {
        return this.play;
    }

    public void setPlay(Moves newPlay) {
        this.play = newPlay;
    }

    public void setRandomPlay() {
        Random moveGenerator = new Random();
        this.play = getMoveByIndex(moveGenerator.nextInt(3));
    }

    public int getWins() {
        return this.wins;
    }

    public void setWins(int newWins) {
        this.wins = newWins;
    }

    public void addWins() {
        this.wins++;
    }

    public int getLoses() {
        return this.loses;
    }

    public void setLoses(int newLoses) {
        this.loses = newLoses;
    }

    public void addLoses() {
        this.loses++;
    }

    @Override
    public String toString() {
        String[] format = new String[3];
        format[0] = "Player " + this.getId() + ":";
        format[1] = "\t"+"Wins - " + this.getWins();
        format[2] = "\t"+"Loses - " + this.getLoses();
        return String.join("\n", format);
    }
}
