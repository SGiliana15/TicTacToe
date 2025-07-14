package org.example;

public class GameLog {
    private int player1Wins = 0;
    private int player2Wins = 0;
    private int ties = 0;

    public void recordWin(char symbol) {
        if (symbol == 'X') player1Wins++;
        else if (symbol == 'O') player2Wins++;
    }

    public void recordTie() {
        ties++;
    }

    public void printStats() {
        System.out.println();
        System.out.println("Player 1 (X) wins: " + player1Wins);
        System.out.println("Player 2 (O) wins: " + player2Wins);
        System.out.println("Ties: " + ties);
        System.out.println();
    }

    public int getPlayer1Wins() {
        return player1Wins;
    }

    public int getPlayer2Wins() {
        return player2Wins;
    }

    public int getTies() {
        return ties;
    }
}