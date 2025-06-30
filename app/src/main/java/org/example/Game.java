package org.example;

import java.util.Scanner;

public class Game {
    private final BoardInterface board;
    private final PrinterInterface printer;
    private final Scanner scanner;

    public Game(BoardInterface board, PrinterInterface printer, Scanner scanner) {
        this.board = board;
        this.printer = printer;
        this.scanner = scanner;
    }

    public void start() {
        char currentPlayer = 'X';
        String currentPlayerName = "Player 1";

        printer.printBoard(board.getBoard());

        while (true) {
            playerTurn(currentPlayer, currentPlayerName);
            printer.printBoard(board.getBoard());

            if (board.hasPlayerWon(currentPlayer)) {
                System.out.println(currentPlayerName + " wins!");
                break;
            }

            if (board.isFull()) {
                System.out.println("The game ended in a tie!");
                break;
            }

            if (currentPlayer == 'X') {
                currentPlayer = 'O';
            } else {
                currentPlayer = 'X';
            }

            if (currentPlayer == 'X') {
                currentPlayerName = "Player 1";
            } else {
                currentPlayerName = "Player 2";
            }
        }
    }

    private void playerTurn(char symbol, String playerName) {
        String userInput;
        while (true) {
            System.out.println(playerName + ", where would you like to play? (1-9)");
            userInput = scanner.nextLine();
            if (board.isValidMove(userInput)) {
                break;
            } else {
                System.out.println(userInput + " is not a valid move.");
            }
        }
        board.placeMove(userInput, symbol);
    }
}