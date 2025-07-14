package org.example;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe!");

        GameLog gameLog = new GameLog();
        char firstPlayer = 'X';

        while (true) {
            BoardInterface board = new Board();
            PrinterInterface printer = new BoardPrinter();
            Game game = new Game(board, printer, scanner, firstPlayer);
            char result = game.start();

            if (result == 'X') {
                gameLog.recordWin('X');
                firstPlayer = 'O';
            } else if (result == 'O') {
                gameLog.recordWin('O');
                firstPlayer = 'X';
            } else {
                gameLog.recordTie();
            }

            gameLog.printStats();

            while (true) {
                System.out.println("Would you like to play again (yes/no)?");
                String response = scanner.nextLine().trim().toLowerCase();

                if (response.equals("yes")) {
                    break;
                } else if (response.equals("no")) {
                    System.out.println();
                    System.out.println("Writing the game log to disk. Please see game.txt for the final statistics!");
                    GameLogWriter.writeToFile(gameLog, "game.txt");
                    scanner.close();
                    return;
                } else {
                    System.out.println("That is not a valid entry!");
                }
            }
        }
    }
}