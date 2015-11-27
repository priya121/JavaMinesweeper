package com.mycompany.app.game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NeighbourMinesTest {

    private ArrayList<Integer> mineLocations;

    public FakeIO getFakeIO(List<String> coordinates) {
        return new FakeIO(coordinates);
    }

    @Before
    public void setUp() throws Exception {
        mineLocations = new ArrayList<Integer>();
    }

    @Test
    public void oneByOneGridIsEmpty() {
        NeighbourMines neighbours = new NeighbourMines(1, mineLocations);
        assertFalse(neighbours.hasMine(0));
    }

    @Test
    public void oneByOneGridWithMine() {
        mineLocations.add(0);
        NeighbourMines neighbours = new NeighbourMines(1, mineLocations);
        assertTrue(neighbours.hasMine(0));
    }

    @Test
    public void twoByTwoGridWithOneMine() {
        FakeIO io = getFakeIO(asList("A2"));
        mineLocations.add(0);
        NeighbourMines game = new NeighbourMines(2, mineLocations);
        assertTrue(game.hasMine(0));
    }

    @Test
    public void twoByTwoGridWithTwoMines() {
        mineLocations.add(0);
        mineLocations.add(1);
        NeighbourMines game = new NeighbourMines(2, mineLocations);
        assertTrue(game.hasMine(0));
        assertTrue(game.hasMine(1));
    }

    @Test
    public void twoByTWoGridWithTwoMinesNotAdjacent() {
        mineLocations.add(0);
        mineLocations.add(2);
        NeighbourMines game = new NeighbourMines(4, mineLocations);
        assertTrue(game.hasMine(0));
        assertTrue(game.hasMine(2));
    }

    @Test
    public void numberOfMinesAroundEmptyCell() {
        NeighbourMines game = new NeighbourMines(4, mineLocations);
        Assert.assertEquals(0, game.neighbourMinesFound(0));
        Assert.assertEquals(0, game.neighbourMinesFound(1));
        Assert.assertEquals(0, game.neighbourMinesFound(2));
        Assert.assertEquals(0, game.neighbourMinesFound(3));
    }

    @Test
    public void numberOfMinesAroundOneMine() {
        mineLocations.add(0);
        NeighbourMines game = new NeighbourMines(4, mineLocations);
        assertTrue(game.hasMine(0));
        assertEquals(1, game.neighbourMinesFound(3));
    }

    @Test
    public void numberOfMinesAroundOneMineAtIndex1() {
        NeighbourMines game = new NeighbourMines(4, mineLocations);
        mineLocations.add(1);
        Assert.assertEquals(1, game.neighbourMinesFound(0));
    }

    @Test
    public void allCoordinatesForThreeByThree() {
        NeighbourMines game = new NeighbourMines(9, mineLocations);
        assertFalse(game.hasMine(0));
    }

    @Test
    public void threeByThreeWithAMine() {
        ArrayList<Integer> mineLocationsOnThreeByThree = new ArrayList<Integer>();
        mineLocationsOnThreeByThree.add(0);
        NeighbourMines game = new NeighbourMines(9, mineLocationsOnThreeByThree);
        assertTrue(game.hasMine(0));
        Assert.assertEquals(1, game.neighbourMinesFound(4));
    }

    @Test
    public void howManyMinesAroundTwoByTwo() {
        NeighbourMines game = new NeighbourMines(4, mineLocations);
        mineLocations.add(0);
        mineLocations.add(1);
        Assert.assertEquals(2, game.neighbourMinesFound(3));
    }

    @Test
    public void howManyMinesAroundThreeByThree() {
        mineLocations.add(4);
        mineLocations.add(3);
        NeighbourMines game = new NeighbourMines(9, mineLocations);
        Assert.assertEquals(2, game.neighbourMinesFound(7));
    }
}
