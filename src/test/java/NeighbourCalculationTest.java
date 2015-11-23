import com.mycompany.app.resources.NeighbourCalculation;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class NeighbourCalculationTest {

    @Test
    public void calculatesNeighbouringCellsForFour() {
        NeighbourCalculation neighbours = new NeighbourCalculation(9,4);
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
        NeighbourCalculation neighbours = new NeighbourCalculation(4,1);
        ArrayList<Integer> neighboursOfCell = new ArrayList<Integer>();
        neighboursOfCell.add(0);
        neighboursOfCell.add(2);
        neighboursOfCell.add(3);
        Assert.assertEquals(neighboursOfCell, neighbours.calculate());
    }

    @Test
    public void calculatesNeighbouringCellsForTwoByTwoAtIndex0() {
        NeighbourCalculation neighbours = new NeighbourCalculation(4,0);
        ArrayList<Integer> neighboursOfCell = new ArrayList<Integer>();
        neighboursOfCell.add(1);
        neighboursOfCell.add(2);
        neighboursOfCell.add(3);
        Assert.assertEquals(neighboursOfCell, neighbours.calculate());
    }

    @Test
    public void calculatesNeighbouringCellsForTwoByTwo() {
        NeighbourCalculation neighbours = new NeighbourCalculation(4, 2);
        ArrayList<Integer> neighboursOfCell = new ArrayList<Integer>();
        neighboursOfCell.add(0);
        neighboursOfCell.add(1);
        neighboursOfCell.add(3);
        Assert.assertEquals(neighboursOfCell, neighbours.calculate());
    }

    @Test
    public void calculatesNeighbouringCellsForFive() {
        NeighbourCalculation neighbours = new NeighbourCalculation(9, 5);
        ArrayList<Integer> neighboursOfCell = new ArrayList<Integer>();
        neighboursOfCell.add(1);
        neighboursOfCell.add(2);
        neighboursOfCell.add(4);
        neighboursOfCell.add(7);
        neighboursOfCell.add(8);
        Assert.assertEquals(neighboursOfCell, neighbours.calculate());
    }

    @Test
    public void calculatesNeighbouringCellsForSix() {
        NeighbourCalculation neighbours = new NeighbourCalculation(9,6);
        ArrayList<Integer> neighboursOfCell = new ArrayList<Integer>();
        neighboursOfCell.add(3);
        neighboursOfCell.add(4);
        neighboursOfCell.add(7);
        Assert.assertEquals(neighboursOfCell, neighbours.calculate());
    }

    @Test
    public void callingCalculateTwiceDoesNotDuplicate() {
        NeighbourCalculation neighbours = new NeighbourCalculation(4,1);
        ArrayList<Integer> neighboursOfCell = new ArrayList<Integer>();
        neighboursOfCell.add(0);
        neighboursOfCell.add(2);
        neighboursOfCell.add(3);
        neighbours.calculate();
        Assert.assertEquals(neighboursOfCell, neighbours.calculate());
    }
}
