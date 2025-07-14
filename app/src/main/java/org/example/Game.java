package org.example;

import java.util.Scanner;

public class Game {
    private final BoardInterface board;
    private final PrinterInterface printer;
    private final Scanner scanner;
    private final char firstPlayer;

    public Game(BoardInterface board, PrinterInterface printer, Scanner scanner, char firstPlayer) {
        this.board = board;
        this.printer = printer;
        this.scanner = scanner;
        this.firstPlayer = firstPlayer;
    }

    public char start() {
        char currentPlayer = firstPlayer;
        String currentPlayerName;

        if (currentPlayer == 'X') {
            currentPlayerName = "Player 1";
        } else {
            currentPlayerName = "Player 2";
        }

        printer.printBoard(board.getBoard());

        while (true) {
            playerTurn(currentPlayer, currentPlayerName);
            printer.printBoard(board.getBoard());

            if (board.hasPlayerWon(currentPlayer)) {
                System.out.println(currentPlayerName + " wins!");
                return currentPlayer;
            }

            if (board.isFull()) {
                System.out.println("The game ended in a tie!");
                return 'T';
            }

            if (currentPlayer == 'X') {
                currentPlayer = 'O';
                currentPlayerName = "Player 2";
            } else {
                currentPlayer = 'X';
                currentPlayerName = "Player 1";
            }
        }
    }

    private void playerTurn(char symbol, String playerName) {
        String userInput;
        while (true) {
            System.out.println(playerName + ", where would you like to play? (1-9)");
            userInput = scanner.nextLine().trim();
            if (board.isValidMove(userInput)) {
                break;
            } else {
                System.out.println(userInput + " is not a valid move.");
            }
        }
        board.placeMove(userInput, symbol);
    }
}