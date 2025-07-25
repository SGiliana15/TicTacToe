package org.example;

public interface Player {
    String getMove(BoardInterface board);
    char getSymbol();
    String getName();
}