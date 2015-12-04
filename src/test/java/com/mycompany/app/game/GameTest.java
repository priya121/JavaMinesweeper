package com.mycompany.app.game;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class GameTest {
    OutputStream recordedOutput = new ByteArrayOutputStream();
    PrintStream actualOutput = new PrintStream(recordedOutput);

    @Test
    public void placesASymbolForMine() {
        ArrayList<Integer> mineLocations = new ArrayList<Integer>();
        ArrayList<Integer> expected = new ArrayList<Integer>();
        Game newGrid = new Game(4);
        mineLocations.addAll(asList(1));
        newGrid.addMines(4);
        expected.addAll(asList(1, 4));
    }

    @Test
    public void convertsBoardToString() {
        DisplayGrid grid = new DisplayGrid(4);
        String[] board = new String[]{"•", "•", "•", "•"};
        String boardConvertedToString = "   1 2 \n" +
                                        "A  • • \n" +
                                        "B  • •";
        assertEquals(boardConvertedToString, grid.convertToStringDisplay(board));
    }

    @Test
    public void tenByTenBoard() {
        DisplayGrid grid = new DisplayGrid(25);
        String[] board = new String[]{"•", "•", "•", "•","•",
                                      "•", "•", "•", "•","•",
                                      "•", "•", "•", "•","•",
                                      "•", "•", "•", "•","•",
                                      "•", "•", "•", "•","•",
                                      "•", "•", "•", "•", "*"};
        String boardConvertedToString =   "   1 2 3 4 5 \n" +
                                          "A  • • • • • \n" +
                                          "B  • • • • • \n" +
                                          "C  • • • • • \n" +
                                          "D  • • • • • \n" +
                                          "E  • • • • • \n" +
                                          "F  • • • • *";
        assertEquals(boardConvertedToString, grid.convertToStringDisplay(board));
    }
}
