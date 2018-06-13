package com.tyntec.rps.classes;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import static com.tyntec.rps.classes.Moves.getMoveByIndex;

/**
 * Characterizes a Player object, with it's own number of wins, loses and ties.
 * Alongside it's currently chosen move and it's auto incrementing Id.
 */
public class Player {

    private static final AtomicInteger count =  new AtomicInteger(1);

    private Moves play;
    private int wins, loses, ties;
    private int id;

    /**
     * Constructor for a Player object where it's move can be passed by parameter.
     * @param chosen
     */
    public Player(Moves chosen) {
        this.setPlay(chosen);
        this.setWins(0);
        this.setLoses(0);
        this.setTies(0);
        this.setId(count.getAndIncrement());
    }

    /**
     * Constructor for a Player object where it's move is randomly selected between the available moves.
     */
    public Player() {
        this.setRandomPlay();
        this.setWins(0);
        this.setLoses(0);
        this.setTies(0);
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

    /**
     * Selects and sets a random move to the player.
     * Normally exception handling would be necessary here, since the getMoveByIndex() method can return null,
     * but since the search is defined to a specific bound, the actual number of moves,
     * it's guaranteed that it will return something other than null.
     */
    public void setRandomPlay() {
        Random moveGenerator = new Random();
        this.play = getMoveByIndex(moveGenerator.nextInt(Moves.values().length));
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

    public int getTies() {
        return this.ties;
    }

    public void setTies(int newTies) {
        this.ties = newTies;
    }

    public void addTies() {
        this.ties++;
    }

    @Override
    public String toString() {
        String[] format = new String[4];
        format[0] = "Player " + this.getId() + ":";
        format[1] = "\t"+"Wins - " + this.getWins();
        format[2] = "\t"+"Loses - " + this.getLoses();
        format[3] = "\t"+"Ties - " + this.getTies();
        return String.join("\n", format);
    }
}