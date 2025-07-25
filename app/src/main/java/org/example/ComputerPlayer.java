package org.example;

import java.util.ArrayList;
import java.util.Random;

public class ComputerPlayer implements Player {
    private char symbol;
    private char opponentSymbol;
    private Random random = new Random();
    private String name = "Computer";

    public ComputerPlayer(char symbol) {
        this.symbol = symbol;
        if (symbol == 'X') {
            opponentSymbol = 'O';
        } else {
            opponentSymbol = 'X';
        }
    }

    public String getMove(BoardInterface board) {
        char[][] b = board.getBoard();
        int movesMade = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (b[i][j] != ' ') movesMade++;

        if (movesMade == 0) {
            String[] corners = {"1", "3", "7", "9"};
            return pickRandomAvailable(corners, board);
        }
        if (movesMade == 1 && board.isValidMove("5")) {
            return "5";
        }
        String winMove = findWinningMove(board, symbol);
        if (winMove != null) return winMove;

        String blockMove = findWinningMove(board, opponentSymbol);
        if (blockMove != null) return blockMove;

        String[] allPositions = {"1","2","3","4","5","6","7","8","9"};
        return pickRandomAvailable(allPositions, board);
    }

    private String pickRandomAvailable(String[] positions, BoardInterface board) {
        ArrayList<String> available = new ArrayList<>();
        for (String pos : positions) {
            if (board.isValidMove(pos)) {
                available.add(pos);
            }
        }
        if (available.isEmpty()) return null;
        return available.get(random.nextInt(available.size()));
    }

    private String findWinningMove(BoardInterface board, char sym) {
        String[] allPositions = {"1","2","3","4","5","6","7","8","9"};
        for (String pos : allPositions) {
            if (board.isValidMove(pos)) {
                board.placeMove(pos, sym);
                boolean wins = board.hasPlayerWon(sym);
                board.placeMove(pos, ' ');
                if (wins) return pos;
            }
        }
        return null;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }
}