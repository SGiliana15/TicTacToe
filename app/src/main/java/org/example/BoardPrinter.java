package org.example;

public class BoardPrinter implements PrinterInterface {
    public void printBoard(char[][] board) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                char cell = board[row][col];
                if (cell == ' ') {
                    System.out.print(row * 3 + col + 1);
                } else {
                    System.out.print(cell);
                }
                if (col < 2) System.out.print("|");
            }
            System.out.println();
            if (row < 2) System.out.println("-+-+-");
        }
    }
}