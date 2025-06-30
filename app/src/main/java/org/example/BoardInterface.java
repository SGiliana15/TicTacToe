package org.example;

public interface BoardInterface {
    boolean isValidMove(String position);
    void placeMove(String position, char symbol);
    boolean hasPlayerWon(char symbol);
    boolean isFull();
    char[][] getBoard();
}