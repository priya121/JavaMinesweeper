package com.mycompany.app.game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NeighbourMineIncrementTest {

    private ArrayList<Integer> mineLocations;

    @Before
    public void setUp() throws Exception {
        mineLocations = new ArrayList<Integer>();
    }

    @Test
    public void oneByOneGridIsEmpty() {
        NeighbourMineIncrement neighbours = new NeighbourMineIncrement(1, mineLocations);
        assertFalse(neighbours.hasMine(0));
    }

    @Test
    public void oneByOneGridWithMine() {
        mineLocations.add(0);
        NeighbourMineIncrement neighbours = new NeighbourMineIncrement(1, mineLocations);
        assertTrue(neighbours.hasMine(0));
    }

    @Test
    public void twoByTwoGridWithOneMine() {
        mineLocations.add(0);
        NeighbourMineIncrement game = new NeighbourMineIncrement(2, mineLocations);
        assertTrue(game.hasMine(0));
    }

    @Test
    public void twoByTwoGridWithTwoMines() {
        mineLocations.add(0);
        mineLocations.add(1);
        NeighbourMineIncrement game = new NeighbourMineIncrement(2, mineLocations);
        assertTrue(game.hasMine(0));
        assertTrue(game.hasMine(1));
    }

    @Test
    public void twoByTWoGridWithTwoMinesNotAdjacent() {
        mineLocations.add(0);
        mineLocations.add(2);
        NeighbourMineIncrement game = new NeighbourMineIncrement(4, mineLocations);
        assertTrue(game.hasMine(0));
        assertTrue(game.hasMine(2));
    }

    @Test
    public void numberOfMinesAroundEmptyCell() {
        NeighbourMineIncrement game = new NeighbourMineIncrement(4, mineLocations);
        Assert.assertEquals(0, game.neighbourMinesFound(0));
        Assert.assertEquals(0, game.neighbourMinesFound(1));
        Assert.assertEquals(0, game.neighbourMinesFound(2));
        Assert.assertEquals(0, game.neighbourMinesFound(3));
    }

    @Test
    public void numberOfMinesAroundOneMine() {
        mineLocations.add(0);
        NeighbourMineIncrement game = new NeighbourMineIncrement(4, mineLocations);
        assertTrue(game.hasMine(0));
        assertEquals(1, game.neighbourMinesFound(3));
    }

    @Test
    public void numberOfMinesAroundOneMineAtIndex1() {
        NeighbourMineIncrement game = new NeighbourMineIncrement(4, mineLocations);
        mineLocations.add(1);
        Assert.assertEquals(1, game.neighbourMinesFound(0));
    }

    @Test
    public void allCoordinatesForThreeByThree() {
        NeighbourMineIncrement game = new NeighbourMineIncrement(9, mineLocations);
        assertFalse(game.hasMine(0));
    }

    @Test
    public void threeByThreeWithAMine() {
        ArrayList<Integer> mineLocationsOnThreeByThree = new ArrayList<Integer>();
        mineLocationsOnThreeByThree.add(0);
        NeighbourMineIncrement game = new NeighbourMineIncrement(9, mineLocationsOnThreeByThree);
        assertTrue(game.hasMine(0));
        Assert.assertEquals(1, game.neighbourMinesFound(4));
    }

    @Test
    public void howManyMinesAroundTwoByTwo() {
        NeighbourMineIncrement game = new NeighbourMineIncrement(4, mineLocations);
        mineLocations.add(0);
        mineLocations.add(1);
        Assert.assertEquals(2, game.neighbourMinesFound(3));
    }

    @Test
    public void howManyMinesAroundThreeByThree() {
        mineLocations.add(4);
        mineLocations.add(3);
        NeighbourMineIncrement game = new NeighbourMineIncrement(9, mineLocations);
        Assert.assertEquals(2, game.neighbourMinesFound(7));
    }
}
