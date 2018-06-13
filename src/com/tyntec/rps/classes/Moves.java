package com.tyntec.rps.classes;

/**
 * Enumerates all of the 'rock paper scissor's possible moves.
 */
public enum Moves {
    rock, paper, scissors;

    /**
     * Specifies the games rule-set.
     * Defining the relations between moves, from the perspective of a player in specific.
     * For example:
     *
     * Player A = new Player(Moves.paper);
     * Player B = new Player(Moves.rock);
     *
     * A.getPlay().compare(B.getPlay())
     *
     * This routine is going to compare A's move with B's move from A's perspective, so, in this case,
     * the method compare() would return 1, which represents a win for player A.
     * If it returned -1, it would represent a loss.
     * If it returned 0, it would represent all the remaining cases, the cases where a tie happened.
     *
     * @param otherPlayer
     * @return An integer representing a win, loss or tie (1, -1, 0, respectively)
     */
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

    /**
     * Searches for a specific move based on a index passed as a parameter.
     * It assembles all the moves' indexes in the all array, then iterates over said array using a 'for each'
     * looking for the index parameter.
     *
     * @param index
     * @return A move with one was found, otherwise returns null.
     */
    public static Moves getMoveByIndex(int index) {
        Moves all[] = Moves.values();
        for (Moves each : all) {
            if (each.ordinal() == index) {
                return each;
            }
        }
        return null;
    }
}
