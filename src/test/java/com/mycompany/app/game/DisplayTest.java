package com.mycompany.app.game;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class DisplayTest {
    ArrayList<Integer> mineLocations;
    ByteArrayOutputStream recordedOutput = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(recordedOutput);
    private InputStream inputStream;

    private FakeIO getFakeIO(List<String> numbers) {
        return new FakeIO(numbers);
    }

    @Before
    public void setup() {
        List<Integer> mineLocations = new ArrayList<Integer>();
    }

    @Test
    @Ignore
    public void placesASymbolForMine() {
        InputStream inputStream = new ByteArrayInputStream("".getBytes());
        ConsoleIO console = new ConsoleIO(inputStream, out);
        Display newGrid = new Display(4);
        String grid = new String("• • \n" +
                                 "• •");
        mineLocations.add(1);
        mineLocations.add(2);
        GameState gameState = new GameState(4, mineLocations);
        newGrid.showInitialState(newGrid, gameState);
    }

}
