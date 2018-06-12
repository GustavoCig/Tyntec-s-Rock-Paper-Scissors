package com.tyntec.rps.classes;

public enum Moves {
    rock, paper, scissors;

    public int compare(Moves otherPlayer) {
        if (this.equals(rock) && otherPlayer.equals(paper)) {
            return 1;
        } else if (this.equals(rock) && otherPlayer.equals(scissors)) {
            return -1;
        } else if (this.equals(paper) && otherPlayer.equals(rock)) {
            return 1;
        } else if (this.equals(paper) && otherPlayer.equals(scissors)) {
            return -1;
        } else if (this.equals(scissors) && otherPlayer.equals(paper)) {
            return 1;
        } else if (this.equals(scissors) && otherPlayer.equals(rock)) {
            return -1;
        }
        return 0;
    }

    public static Moves getMoveByIndex(int index) {
        Moves all[] = Moves.values();
        for (Moves each : all) {
            if (each.ordinal() == index) {
                return each;
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
