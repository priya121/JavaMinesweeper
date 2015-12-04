package com.mycompany.app.game;

import org.junit.Before;
import org.junit.Test;

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
    public void revealsEmptyCells() {
        ArrayList<Integer> mineLocations = new ArrayList<Integer>();
        List<Integer> uncheckedList = new ArrayList<Integer>();
        uncheckedList.addAll(asList(0, 1, 2, 4));
        RecursiveReveal reveal = new RecursiveReveal(4, mineLocations, uncheckedList);
        game = new GameState(4, mineLocations);
        reveal.recursiveReveal(0, game);
        String[] grid = new String[]{"0", "0", "0", "0"};
        assertEquals(grid, game.getCurrentState());
    }

    @Test
    public void revealsIndividualCellIfNotZero() {
        ArrayList<Integer> mineLocations = new ArrayList<Integer>();
        mineLocations.add(3);
        List<Integer> uncheckedList = new ArrayList<Integer>();
        uncheckedList.addAll(asList(0, 1, 2, 4));
        RecursiveReveal reveal = new RecursiveReveal(4, mineLocations, uncheckedList);
        game = new GameState(4, mineLocations);
        String[] expectedGrid = new String[]{"1", "•", "•", "•"};
        reveal.checkIfRecurse(0, game);
        assertEquals(expectedGrid, game.getCurrentState());
    }

    @Test
    public void revealAllCellsExceptMine() {
        ArrayList<Integer> mineLocations = new ArrayList<Integer>();
        mineLocations.add(8);
        List<Integer> uncheckedList = new ArrayList<Integer>();
        uncheckedList.addAll(asList(0, 1, 2, 4, 5, 6, 7, 8));
        RecursiveReveal reveal = new RecursiveReveal(9, mineLocations, uncheckedList);
        game = new GameState(9, mineLocations);
        String[] expectedGrid = new String[]{"0", "0", "0", "0", "1","1","0","1","•"};
        reveal.recursiveReveal(3,game);
        assertEquals(expectedGrid, game.getCurrentState());
    }

    @Test
    public void revealsEmptyPatchOnTenByTenGrid() {
        ArrayList<Integer> mineLocations = new ArrayList<Integer>();
        mineLocations.add(8);
        List<Integer> uncheckedList = new ArrayList<Integer>();
        uncheckedList.addAll(asList(0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 23, 24, 25));
        RecursiveReveal reveal = new RecursiveReveal(25, mineLocations, uncheckedList);
        game = new GameState(25, mineLocations);
        String[] expectedGrid = new String[]{"0", "0", "1", "•", "•",
                                             "0", "0", "1", "•", "•",
                                             "0", "0", "1", "1", "1",
                                             "0", "0", "0", "0", "0",
                                             "0", "0", "0", "0", "0"};
        reveal.recursiveReveal(6, game);
        assertEquals(expectedGrid, game.getCurrentState());
    }

    @Test
    public void revealsEmptyPatchOnEdgeOfTenByTenGrid() {
        ArrayList<Integer> mineLocations = new ArrayList<Integer>();
        mineLocations.add(8);
        List<Integer> uncheckedList = new ArrayList<Integer>();
        uncheckedList.addAll(asList(0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 23, 24, 25));
        RecursiveReveal reveal = new RecursiveReveal(25, mineLocations, uncheckedList);
        game = new GameState(25, mineLocations);
        String[] expectedGrid = new String[]{"0", "0", "1", "•", "•",
                                             "0", "0", "1", "•", "•",
                                             "0", "0", "1", "1", "1",
                                             "0", "0", "0", "0", "0",
                                             "0", "0", "0", "0", "0"};
        reveal.checkIfRecurse(0,game);
        assertEquals(expectedGrid, game.getCurrentState());
    }

    @Test
    public void revealsNeighboursIfNot0() {
        ArrayList<Integer> mineLocations = new ArrayList<Integer>();
        mineLocations.add(8);
        List<Integer> uncheckedList = new ArrayList<Integer>();
        uncheckedList.addAll(asList(0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 23, 24, 25));
        RecursiveReveal reveal = new RecursiveReveal(25, mineLocations, uncheckedList);
        game = new GameState(25, mineLocations);
        String[] expectedGrid = new String[]{"•", "•", "1", "•", "•",
                                             "•", "•", "•", "•", "•",
                                             "•", "•", "•", "•", "•",
                                             "•", "•", "•", "•", "•",
                                             "•", "•", "•", "•", "•"};
        reveal.checkIfRecurse(2,game);
        assertEquals(expectedGrid, game.getCurrentState());
    }

    @Test
    public void revealsEmptyPatchInMiddleOfTenByTenGrid() {
        ArrayList<Integer> mineLocations = new ArrayList<Integer>();
        mineLocations.addAll(asList(0,1,2,3,4,5,9,10,14,15,19,20,21,22,23,24));
        List<Integer> uncheckedList = new ArrayList<Integer>();
        uncheckedList.addAll(asList(0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25));
        RecursiveReveal reveal = new RecursiveReveal(25, mineLocations, uncheckedList);
        game = new GameState(25, mineLocations);
        String[] expectedGrid = new String[]{"•", "•", "•", "•", "•",
                                             "•", "5", "3", "5", "•",
                                             "•", "3", "0", "3", "•",
                                             "•", "5", "3", "5", "•",
                                             "•", "•", "•", "•", "•"};
        reveal.checkIfRecurse(12,game);
        assertEquals(expectedGrid, game.getCurrentState());
    }
}
