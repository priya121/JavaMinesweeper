package com.mycompany.app.game;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class NeighbourCalculationTest {

    @Test
    public void calculatesNeighbouringCellsForFour() {
        NeighboursCalculation neighbours = new NeighboursCalculation(9,4);
        ArrayList<Integer> neighboursOfCell = new ArrayList<Integer>();
        neighboursOfCell.add(0);
        neighboursOfCell.add(1);
        neighboursOfCell.add(2);
        neighboursOfCell.add(3);
        neighboursOfCell.add(5);
        neighboursOfCell.add(6);
        neighboursOfCell.add(7);
        neighboursOfCell.add(8);
        Assert.assertEquals(neighboursOfCell, neighbours.calculate());
    }

    @Test
    public void calculatesNeighbouringCellsForTwoByTwoAtIndex1() {
        NeighboursCalculation neighbours = new NeighboursCalculation(4,1);
        ArrayList<Integer> neighboursOfCell = new ArrayList<Integer>();
        neighboursOfCell.add(0);
        neighboursOfCell.add(2);
        neighboursOfCell.add(3);
        Assert.assertEquals(neighboursOfCell, neighbours.calculate());
    }

    @Test
    public void calculatesNeighbouringCellsForTwoByTwoAtIndex0() {
        NeighboursCalculation neighbours = new NeighboursCalculation(4,0);
        ArrayList<Integer> neighboursOfCell = new ArrayList<Integer>();
        neighboursOfCell.add(1);
        neighboursOfCell.add(2);
        neighboursOfCell.add(3);
        Assert.assertEquals(neighboursOfCell, neighbours.calculate());
    }

    @Test
    public void calculatesNeighbouringCellsForTwoByTwo() {
        NeighboursCalculation neighbours = new NeighboursCalculation(4, 2);
        ArrayList<Integer> neighboursOfCell = new ArrayList<Integer>();
        neighboursOfCell.add(0);
        neighboursOfCell.add(1);
        neighboursOfCell.add(3);
        Assert.assertEquals(neighboursOfCell, neighbours.calculate());
    }

    @Test
    public void calculatesNeighbouringCellsForFive() {
        NeighboursCalculation neighbours = new NeighboursCalculation(9, 5);
        ArrayList<Integer> neighboursOfCell = new ArrayList<Integer>();
        neighboursOfCell.add(1);
        neighboursOfCell.add(2);
        neighboursOfCell.add(4);
        neighboursOfCell.add(7);
        neighboursOfCell.add(8);
        Assert.assertEquals(neighboursOfCell, neighbours.calculate());
    }

    @Test
    public void calculatesIndex1OnNineByNine() {
        NeighboursCalculation neighbours = new NeighboursCalculation(9, 1);
        ArrayList<Integer> neighboursOfCell = new ArrayList<Integer>();
        neighboursOfCell.add(0);
        neighboursOfCell.add(2);
        neighboursOfCell.add(3);
        neighboursOfCell.add(4);
        neighboursOfCell.add(5);
        Assert.assertEquals(neighboursOfCell, neighbours.calculate());
    }

    @Test
    public void calculatesNeighbouringCellsForSix() {
        NeighboursCalculation neighbours = new NeighboursCalculation(9,6);
        ArrayList<Integer> neighboursOfCell = new ArrayList<Integer>();
        neighboursOfCell.add(3);
        neighboursOfCell.add(4);
        neighboursOfCell.add(7);
        Assert.assertEquals(neighboursOfCell, neighbours.calculate());
    }

    @Test
    public void callingCalculateTwiceDoesNotDuplicate() {
        NeighboursCalculation neighbours = new NeighboursCalculation(4,1);
        ArrayList<Integer> neighboursOfCell = new ArrayList<Integer>();
        neighboursOfCell.add(0);
        neighboursOfCell.add(2);
        neighboursOfCell.add(3);
        neighbours.calculate();
        Assert.assertEquals(neighboursOfCell, neighbours.calculate());
    }

    @Test
    public void largerBoard() {
        NeighboursCalculation neighbours = new NeighboursCalculation(100,55);
        ArrayList<Integer> neighboursOfCell = new ArrayList<Integer>();
        neighboursOfCell.add(44);
        neighboursOfCell.add(45);
        neighboursOfCell.add(46);
        neighboursOfCell.add(54);
        neighboursOfCell.add(56);
        neighboursOfCell.add(64);
        neighboursOfCell.add(65);
        neighboursOfCell.add(66);
        neighbours.calculate();
        Assert.assertEquals(neighboursOfCell, neighbours.calculate());
    }
}
