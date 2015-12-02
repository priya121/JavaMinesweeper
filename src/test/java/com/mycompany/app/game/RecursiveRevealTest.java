package com.mycompany.app.game;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class RecursiveRevealTest {

    private NeighboursCalculation neighbourCalculation;
    private ArrayList<Integer> mineLocations;
    GameState game = new GameState(9, mineLocations);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getNeighbourCellsForFirstPosition() {
        ArrayList<Integer> mineLocations = new ArrayList<Integer>();
        mineLocations.add(1);
        List<Integer> uncheckedPositions = new ArrayList<Integer>();
        uncheckedPositions.addAll(asList(0, 1, 2));
        RecursiveReveal reveal = new RecursiveReveal(4, mineLocations, uncheckedPositions);
        assertEquals(3, reveal.getNeighbours(0).size());
    }

    @Test
    public void getNeighbourCellsForThreeByThreeBoard() {
        ArrayList<Integer> mineLocations = new ArrayList<Integer>();
        List<Integer> uncheckedList = new ArrayList<Integer>();
        mineLocations.add(1);
        RecursiveReveal reveal = new RecursiveReveal(9, mineLocations, uncheckedList);
        assertEquals(5, reveal.getNeighbours(1).size());
    }

    @Test
    public void revealAllCellsExceptMine() {
        ArrayList<Integer> mineLocations = new ArrayList<Integer>();
        mineLocations.add(8);
        List<Integer> uncheckedList = new ArrayList<Integer>();
        uncheckedList.addAll(asList(0, 1, 2, 4, 5, 6, 7, 8));
        RecursiveReveal reveal = new RecursiveReveal(9, mineLocations, uncheckedList);
        game = new GameState(9, mineLocations);
        String finalGrid = "   1 2 3 \n" +
                           "A  0 0 0 \n" +
                           "B  0 1 1 \n" +
                           "C  0 1 •";
        assertEquals(finalGrid, convertToString(reveal.recursiveReveal(3, game), 9));
    }

    @Test
    public void revealsEmptyPatchOnTenByTenGrid() {
        ArrayList<Integer> mineLocations = new ArrayList<Integer>();
        mineLocations.add(8);
        List<Integer> uncheckedList = new ArrayList<Integer>();
        uncheckedList.addAll(asList(0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 23, 24, 25));
        RecursiveReveal reveal = new RecursiveReveal(25, mineLocations, uncheckedList);
        game = new GameState(25, mineLocations);
        String finalGrid ="   1 2 3 4 5 \n" +
                          "A  0 0 1 • • \n" +
                          "B  0 0 1 • • \n" +
                          "C  0 0 1 1 1 \n" +
                          "D  0 0 0 0 0 \n" +
                          "E  0 0 0 0 0";
        assertEquals(finalGrid, convertToString(reveal.recursiveReveal(0, game), 25));
    }

    private String convertToString(GameState game, int size) {
        ByteArrayOutputStream recordedOutput = new ByteArrayOutputStream();
        InputStream inputStream = new ByteArrayInputStream("A1\n".getBytes());
        PrintStream out = new PrintStream(recordedOutput);
        IO io = new ConsoleIO(inputStream, out);
        Display newGrid = new Display(size);
        return newGrid.convertToStringDisplay(game.getCurrentState());
    }
}
