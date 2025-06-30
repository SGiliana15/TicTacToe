package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class AppTest {
  private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testInitialBoardIsEmpty() {
        for (int i = 1; i <= 9; i++) {
            assertTrue(board.isValidMove(Integer.toString(i)));
        }
    }

    @Test
    public void testPlaceMoveAndIsValidMove() {
        assertTrue(board.isValidMove("1"));
        board.placeMove("1", 'X');
        assertFalse(board.isValidMove("1"));
    }

    @Test
    public void testHasPlayerWonRow() {
        board.placeMove("1", 'X');
        board.placeMove("2", 'X');
        board.placeMove("3", 'X');
        assertTrue(board.hasPlayerWon('X'));
    }

    @Test
    public void testHasPlayerWonColumn() {
        board.placeMove("1", 'O');
        board.placeMove("4", 'O');
        board.placeMove("7", 'O');
        assertTrue(board.hasPlayerWon('O'));
    }

    @Test
    public void testHasPlayerWonDiagonal() {
        board.placeMove("1", 'X');
        board.placeMove("5", 'X');
        board.placeMove("9", 'X');
        assertTrue(board.hasPlayerWon('X'));
    }

    @Test
    public void testIsFull() {
        for (int i = 1; i <= 9; i++) {
            board.placeMove(Integer.toString(i), 'X');
        }
        assertTrue(board.isFull());
    }

    @Test
    public void testIsNotFull() {
        board.placeMove("1", 'X');
        assertFalse(board.isFull());
    }

    @Test
    public void testInvalidPosition() {
        assertFalse(board.isValidMove("10"));
    }
}