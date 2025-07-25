package org.example;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe!");

        GameLog gameLog = new GameLog();

        while (true) {
            System.out.println("Select game mode:");
            System.out.println("1 - Human vs Human");
            System.out.println("2 - Human vs Computer");

            String modeInput;
            int mode = 0;
            while (mode == 0) {
                System.out.print("Enter 1 or 2: ");
                modeInput = scanner.nextLine().trim();
                if (modeInput.equals("1") || modeInput.equals("2")) {
                    mode = Integer.parseInt(modeInput);
                } else {
                    System.out.println("Invalid input, please enter 1 or 2.");
                }
            }

            Player player1;
            Player player2;

            if (mode == 1) {
                player1 = new HumanPlayer(scanner, 'X', "Player 1");
                player2 = new HumanPlayer(scanner, 'O', "Player 2");
            } else {
                System.out.println("Who goes first?");
                System.out.println("1 - Human (X)");
                System.out.println("2 - Computer (X)");

                String firstInput;
                int first = 0;
                while (first == 0) {
                    System.out.print("Enter 1 or 2: ");
                    firstInput = scanner.nextLine().trim();
                    if (firstInput.equals("1") || firstInput.equals("2")) {
                        first = Integer.parseInt(firstInput);
                    } else {
                        System.out.println("Invalid input, please enter 1 or 2.");
                    }
                }

                if (first == 1) {
                    player1 = new HumanPlayer(scanner, 'X', "Player");
                    player2 = new ComputerPlayer('O');
                } else {
                    player1 = new ComputerPlayer('X');
                    player2 = new HumanPlayer(scanner, 'O', "Player");
                }
            }

            BoardInterface board = new Board();
            PrinterInterface printer = new BoardPrinter();
            Game game = new Game(board, printer, player1, player2);

            char result = game.start();

            boolean humanVsHuman = (player1 instanceof HumanPlayer) && (player2 instanceof HumanPlayer);

            if (humanVsHuman) {
                if (result == 'X') {
                    gameLog.recordWin('X');
                } else if (result == 'O') {
                    gameLog.recordWin('O');
                } else {
                    gameLog.recordTie();
                }
                gameLog.printStats();
            }

            while (true) {
                System.out.println("Would you like to play again (yes/no)?");
                String response = scanner.nextLine().trim().toLowerCase();

                if (response.equals("yes")) {
                    break;
                } else if (response.equals("no")) {
                    System.out.println();
                    if (humanVsHuman && 
                        (gameLog.getPlayer1Wins() > 0 || gameLog.getPlayer2Wins() > 0 || gameLog.getTies() > 0)) {
                        System.out.println("Writing the game log to disk. Please see game.txt for the final statistics!");
                        GameLogWriter.writeToFile(gameLog, "game.txt");
                    }
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                } else {
                    System.out.println("That is not a valid entry!");
                }
            }
        }
    }
}