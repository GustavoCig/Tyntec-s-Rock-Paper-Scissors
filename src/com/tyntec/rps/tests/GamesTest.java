package com.tyntec.rps.tests;

import com.tyntec.rps.classes.Games;
import org.junit.Test;
import static org.junit.Assert.*;

public class GamesTest {

    @Test
    public void verifyResultTest() {
        Games A = new Games(1);
        A.verifyResult(1);
        assertEquals(1, A.getPlayerOne().getWins());
    }
}