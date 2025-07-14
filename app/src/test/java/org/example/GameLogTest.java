package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameLogTest {

    @Test
    void testInitialValuesAreZero() {
        GameLog log = new GameLog();
        assertEquals(0, log.getPlayer1Wins());
        assertEquals(0, log.getPlayer2Wins());
        assertEquals(0, log.getTies());
    }

    @Test
    void testRecordPlayer1Win() {
        GameLog log = new GameLog();
        log.recordWin('X');
        assertEquals(1, log.getPlayer1Wins());
        assertEquals(0, log.getPlayer2Wins());
    }

    @Test
    void testRecordPlayer2Win() {
        GameLog log = new GameLog();
        log.recordWin('O');
        assertEquals(1, log.getPlayer2Wins());
        assertEquals(0, log.getPlayer1Wins());
    }

    @Test
    void testRecordTie() {
        GameLog log = new GameLog();
        log.recordTie();
        assertEquals(1, log.getTies());
    }
}