package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class GameLogWriter {
    public static void writeToFile(GameLog gameLog, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Final Tic-Tac-Toe Game Statistics\n");
            writer.write("-------------------------------\n");
            writer.write("Player 1 (X) wins: " + gameLog.getPlayer1Wins() + "\n");
            writer.write("Player 2 (O) wins: " + gameLog.getPlayer2Wins() + "\n");
            writer.write("Ties: " + gameLog.getTies() + "\n");
            writer.write("-------------------------------\n");
        } catch (IOException e) {
            System.out.println("Error writing game log to file: " + e.getMessage());
        }
    }
}