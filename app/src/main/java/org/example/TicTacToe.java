package org.example;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe!");

        BoardInterface board;
        PrinterInterface printer;
        Game game;

        while (true) {
            board = new Board();
            printer = new BoardPrinter();
            game = new Game(board, printer, scanner);
            game.start();

            while (true) {
                System.out.println("\nWould you like to play again (yes/no)?");
                String response = scanner.nextLine().trim().toLowerCase();

                if (response.equals("yes")) {
                    break;
                } else if (response.equals("no")) {
                    System.out.println("\nGoodbye!");
                    scanner.close();
                    return;
                } else {
                    System.out.println("\nThat is not a valid entry!");
                }
            }
        }
    }
}