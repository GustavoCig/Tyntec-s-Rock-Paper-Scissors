package com.tyntec.rps.classes;

public class Games {

    private Player one, two;
    private int ties, numberOfGames;

    public Games(int quantity) {
        this.setPlayerOne(new Player());
        this.setPlayerTwo(new Player());
        this.setNumberOfGames(quantity);
        this.setTies(0);
    }

    public Games(Player fixed, int quantity) {
        this.setPlayerOne(fixed);
        this.setPlayerTwo(new Player());
        this.setNumberOfGames(quantity);
        this.setTies(0);
    }

    public Games start() {
        for(int round = 0; round < numberOfGames; round++) {
            verifyResult();
            this.getPlayerOne().setRandomPlay();
            this.getPlayerTwo().setRandomPlay();
        }
        return this;
    }

    public Games startWithPlayerOneFixed() {
        for(int round = 0; round < numberOfGames; round++) {
            verifyResult();
            this.getPlayerTwo().setRandomPlay();
        }
        return this;
    }

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
                this.addTies();
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

    public int getTies() {
        return this.ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public void addTies() {
        this.ties++;
    }

    @Override
    public String toString() {
        String[] format = new String[5];
        format[0] = "Game:";
        format[1] = this.getPlayerOne().toString();
        format[2] = this.getPlayerTwo().toString();
        format[3] = "Ties - " + this.getTies();
        format[4] = "Total Games - " + this.getNumberOfGames();
        return String.join("\n", format);
    }
}
