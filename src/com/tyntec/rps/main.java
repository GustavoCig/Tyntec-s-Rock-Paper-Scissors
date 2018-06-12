package com.tyntec.rps;

import com.tyntec.rps.classes.Moves;
import com.tyntec.rps.classes.Player;
import com.tyntec.rps.classes.Games;

public class main {

    /**
     * Runs a set of games using the behaviour specified for this assignment;
     * Where a player always plays the same move, 'paper', and the other player chooses it's play randomly
     * Method ends by showing a summary of the games, with the wins and loses per player, and the number of ties
     */
    private static void runDefaultBehavior() {
        Player playerA = new Player(Moves.paper);
        int numberOfGames = 100;
        Games competition = new Games(playerA, numberOfGames);
        System.out.println(competition.startWithPlayerOneFixed());
    }

    /**
     * Runs a normal set of 'rock-paper-scissors' games
     * Method ends by showing a summary of the games, with the wins and loses per player, and the number of ties
     */
    private static void runNormalGame() {
        int numberOfGames = 100;
        Games competition = new Games(numberOfGames);
        System.out.println(competition.start());
    }

    public static void main(String args[]) {
        runDefaultBehavior();
    }
}