package com.tyntec.rps.tests;

import com.tyntec.rps.classes.Moves;
import org.junit.Test;
import static org.junit.Assert.*;

public class MovesTest {

    @Test
    public void compareTest() {
        assertEquals(1, Moves.paper.compare(Moves.rock));
    }

    @Test
    public void getMoveByIndexTest() {
        assertEquals(Moves.rock, Moves.getMoveByIndex(0));
    }
}