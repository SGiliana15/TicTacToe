package org.example;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Scanner scanner;
    private final char symbol;
    private final String name;

    public HumanPlayer(Scanner scanner, char symbol, String name) {
        this.scanner = scanner;
        this.symbol = symbol;
        this.name = name;
    }

    public String getMove(BoardInterface board) {
        String input;
        while (true) {
            System.out.println(name + " (" + symbol + "), where would you like to play? (1-9)");
            input = scanner.nextLine().trim();
            if (board.isValidMove(input)) {
                break;
            }
            System.out.println(input + " is not a valid move.");
        }
        return input;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }
}