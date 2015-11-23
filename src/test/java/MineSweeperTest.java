import com.mycompany.app.resources.FakeIO;
import com.mycompany.app.resources.MineSweeper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MineSweeperTest {

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
        FakeIO io = getFakeIO(asList("A2"));
        MineSweeper game = new MineSweeper(io, 1, mineLocations);
        assertFalse(game.hasMine(0));
    }

    @Test
    public void oneByOneGridWithMine() {
        FakeIO io = getFakeIO(asList("A2"));
        mineLocations.add(0);
        MineSweeper game = new MineSweeper(io, 1, mineLocations);
        assertTrue(game.hasMine(0));
    }

    @Test
    public void twoByTwoGridWithOneMine() {
        FakeIO io = getFakeIO(asList("A2"));
        mineLocations.add(0);
        MineSweeper game = new MineSweeper(io, 2, mineLocations);
        assertTrue(game.hasMine(0));
    }

    @Test
    public void twoByTwoGridWithTwoMines() {
        FakeIO io = getFakeIO(asList("A2"));
        mineLocations.add(0);
        mineLocations.add(1);
        MineSweeper game = new MineSweeper(io, 2, mineLocations);
        assertTrue(game.hasMine(0));
        assertTrue(game.hasMine(1));
    }

    @Test
    public void twoByTWoGridWithTwoMinesNotAdjacent() {
        FakeIO io = getFakeIO(asList("A2"));
        mineLocations.add(0);
        mineLocations.add(2);
        MineSweeper game = new MineSweeper(io, 4, mineLocations);
        assertTrue(game.hasMine(0));
        assertTrue(game.hasMine(2));
    }

    @Test
    public void numberOfMinesAroundEmptyCell() {
        FakeIO io = getFakeIO(asList("A2"));
        MineSweeper game = new MineSweeper(io, 4, mineLocations);
        Assert.assertEquals(0, game.neighbourMinesFound(0));
        Assert.assertEquals(0, game.neighbourMinesFound(1));
        Assert.assertEquals(0, game.neighbourMinesFound(2));
        Assert.assertEquals(0, game.neighbourMinesFound(3));
    }

    @Test
    public void numberOfMinesAroundOneMine() {
        FakeIO io = getFakeIO(asList("A2"));
        mineLocations.add(0);
        MineSweeper game = new MineSweeper(io, 4, mineLocations);
        Assert.assertEquals(0, game.neighbourMinesFound(0));
        Assert.assertEquals(1, game.neighbourMinesFound(1));
        Assert.assertEquals(1, game.neighbourMinesFound(2));
        Assert.assertEquals(1, game.neighbourMinesFound(3));
    }

    @Test
    public void numberOfMinesAroundOneMineAtIndex1() {
        FakeIO io = getFakeIO(asList("A2"));
        MineSweeper game = new MineSweeper(io, 4, mineLocations);
        mineLocations.add(1);
        Assert.assertEquals(1, game.neighbourMinesFound(0));
        Assert.assertEquals(0, game.neighbourMinesFound(1));
        Assert.assertEquals(1, game.neighbourMinesFound(2));
        Assert.assertEquals(1, game.neighbourMinesFound(3));
    }

    @Test
    public void allCoordinatesForThreeByThree() {
        FakeIO io = getFakeIO(asList("A2"));
        MineSweeper game = new MineSweeper(io, 9, mineLocations);
        assertFalse(game.hasMine(0));
    }

    @Test
    public void threeByThreeWithAMine() {
        FakeIO io = getFakeIO(asList("A2"));
        MineSweeper game = new MineSweeper(io, 9, mineLocations);
        assertFalse(game.hasMine(0));
        mineLocations.add(0);
        Assert.assertEquals(0, game.neighbourMinesFound(0));
        Assert.assertEquals(1, game.neighbourMinesFound(1));
        Assert.assertEquals(0, game.neighbourMinesFound(2));
        Assert.assertEquals(1, game.neighbourMinesFound(3));
        Assert.assertEquals(1, game.neighbourMinesFound(4));
        Assert.assertEquals(0, game.neighbourMinesFound(5));
        Assert.assertEquals(0, game.neighbourMinesFound(6));
        Assert.assertEquals(0, game.neighbourMinesFound(7));
        Assert.assertEquals(0, game.neighbourMinesFound(8));
    }

    @Test
    public void howManyMinesAroundTwoByTwo() {
        FakeIO io = getFakeIO(asList("A2"));
        MineSweeper game = new MineSweeper(io, 4, mineLocations);
        mineLocations.add(0);
        mineLocations.add(1);
        Assert.assertEquals(0, game.neighbourMinesFound(0));
        Assert.assertEquals(0, game.neighbourMinesFound(1));
        Assert.assertEquals(2, game.neighbourMinesFound(2));
        Assert.assertEquals(2, game.neighbourMinesFound(3));
    }

    @Test
    public void howManyMinesAroundThreeByThree() {
        FakeIO io = getFakeIO(asList("A1"));
        mineLocations.add(4);
        mineLocations.add(3);
        MineSweeper game = new MineSweeper(io, 9, mineLocations);
        Assert.assertEquals(2, game.neighbourMinesFound(0));
        Assert.assertEquals(2, game.neighbourMinesFound(1));
        Assert.assertEquals(1, game.neighbourMinesFound(2));
        Assert.assertEquals(0, game.neighbourMinesFound(3));
        Assert.assertEquals(0, game.neighbourMinesFound(4));
        Assert.assertEquals(1, game.neighbourMinesFound(5));
        Assert.assertEquals(2, game.neighbourMinesFound(6));
        Assert.assertEquals(2, game.neighbourMinesFound(7));
        Assert.assertEquals(1, game.neighbourMinesFound(8));
    }
}
