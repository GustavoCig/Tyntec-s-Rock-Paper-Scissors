package com.tyntec.rps.classes;

/**
 * Characterizes a Games object with two specific players per Games object.
 * And also a total number of games that are going to happen between these two players.
 */
public class Games {

    private Player one, two;
    private int numberOfGames;

    /**
     * Constructor for a Games object where both Players have their moves randomly defined.
     * @param numberOfGames
     */
    public Games(int numberOfGames) {
        this.setPlayerOne(new Player());
        this.setPlayerTwo(new Player());
        this.setNumberOfGames(numberOfGames);
    }

    /**
     * Constructor for a Games object where one of the players is passed as a parameter
     * while the second player is instantiated with a random move.
     * @param staticPlayer
     * @param numberOfGames
     */
    public Games(Player staticPlayer, int numberOfGames) {
        this.setPlayerOne(staticPlayer);
        this.setPlayerTwo(new Player());
        this.setNumberOfGames(numberOfGames);
    }

    /**
     * Starts the games looping a {numberOfGames} times,
     * each time a game is played and after that both player's moves are randomized.
     * @return this
     */
    public Games start() {
        for(int round = 0; round < numberOfGames; round++) {
            verifyResult();
            this.getPlayerOne().setRandomPlay();
            this.getPlayerTwo().setRandomPlay();
        }
        return this;
    }

    /**
     * Starts the games looping a {numberOfGames} times,
     * each time a game is played and after that one of the player's moves is randomized
     * while th other player remains static.
     * @return this
     */
    public Games startWithPlayerOneFixed() {
        for(int round = 0; round < numberOfGames; round++) {
            verifyResult();
            this.getPlayerTwo().setRandomPlay();
        }
        return this;
    }

    /**
     * Verifies a game's result and changes each player's values accordingly.
     */
    private void verifyResult() {
        switch(this.one.getPlay().compare(this.two.getPlay())) {
            case 1:
                this.getPlayerOne().addWins();
                this.getPlayerTwo().addLoses();
                break;
            case -1:
                this.getPlayerTwo().addWins();
                this.getPlayerOne().addLoses();
                break;
            case 0:
                this.getPlayerOne().addTies();
                this.getPlayerTwo().addTies();
                break;
        }
    }

    public Player getPlayerOne() {
        return one;
    }

    public void setPlayerOne(Player one) {
        this.one = one;
    }

    public Player getPlayerTwo() {
        return two;
    }

    public void setPlayerTwo(Player two) {
        this.two = two;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public void setNumberOfGames(int numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    @Override
    public String toString() {
        String[] format = new String[4];
        format[0] = "Game:";
        format[1] = this.getPlayerOne().toString();
        format[2] = this.getPlayerTwo().toString();
        format[3] = "Total Games - " + this.getNumberOfGames();
        return String.join("\n", format);
    }
}
