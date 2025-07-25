package org.example;

public class Game {
    private final BoardInterface board;
    private final PrinterInterface printer;
    private final Player player1;
    private final Player player2;

    public Game(BoardInterface board, PrinterInterface printer, Player player1, Player player2) {
        this.board = board;
        this.printer = printer;
        this.player1 = player1;
        this.player2 = player2;
    }

    public char start() {
        Player currentPlayer = player1;
        printer.printBoard(board.getBoard());

        while (true) {
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + ")");
            String move = currentPlayer.getMove(board);
            board.placeMove(move, currentPlayer.getSymbol());

            printer.printBoard(board.getBoard());

            if (board.hasPlayerWon(currentPlayer.getSymbol())) {
                System.out.println(currentPlayer.getName() + " wins!");
                return currentPlayer.getSymbol();
            }

            if (board.isFull()) {
                System.out.println("The game ended in a tie!");
                return 'T';
            }

            if (currentPlayer == player1) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        }
    }
}