package com.mycompany.app.game;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;


public class DisplayTest {
    ArrayList<Integer> mineLocations;

    private FakeIO getFakeIO(List<String> numbers) {
        return new FakeIO(numbers);
    }

    @Before
    public void setup() {
        List<Integer> mineLocations = new ArrayList<Integer>();
        mineLocations.add(1);
        mineLocations.add(2);
    }

    @Test
    public void placesASymbolForMine() {
        ArrayList<Integer> mineLocations = null;
        FakeIO io = getFakeIO(asList("A2"));
        Display newGrid = new Display(io, 4);
    }
}
