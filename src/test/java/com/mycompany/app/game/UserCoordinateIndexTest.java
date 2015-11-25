package com.mycompany.app.game;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertEquals;

public class UserCoordinateIndexTest {
    private UserCoordinateIndex userCoordinateIndex;

    private FakeIO getFakeIO(List<String> numbers) {
        return new FakeIO(numbers);
    }

    @Test
    public void userInputsCoordinateInsteadOfIndex() {
        FakeIO io = getFakeIO(asList("A1"));
        String guess = "A1";
        userCoordinateIndex = new UserCoordinateIndex(guess, 4);
        assertEquals(0, userCoordinateIndex.convertCoordinateToIndex());
    }

    @Test
    public void anotherUserInputsCoordinateInsteadOfIndex() {
        FakeIO io = getFakeIO(asList("B1"));
        String guess = "B1";
        userCoordinateIndex = new UserCoordinateIndex(guess, 4);
        assertEquals(2, userCoordinateIndex.convertCoordinateToIndex());
    }

    @Test
    public void takesInputWithCCoordinate() {
        FakeIO io = getFakeIO(asList("C3"));
        String guess = "C3";
        userCoordinateIndex = new UserCoordinateIndex(guess, 9);
        assertEquals(8, userCoordinateIndex.convertCoordinateToIndex());
    }

    @Test
    public void takesInputWithECoordinate() {
        FakeIO io = getFakeIO(asList("E1"));
        String guess = "E1";
        userCoordinateIndex = new UserCoordinateIndex(guess, 25);
        assertEquals(20, userCoordinateIndex.convertCoordinateToIndex());
    }

    @Test
    public void takesInputWithHCoordinate() {
        FakeIO io = getFakeIO(asList("H6"));
        String guess = "H6";
        userCoordinateIndex = new UserCoordinateIndex(guess, 100);
        assertEquals(75, userCoordinateIndex.convertCoordinateToIndex());
    }

    @Test
    public void addsTwentyIfRowE() {
        FakeIO io = getFakeIO(asList("H1"));
        String guess = "H1";
        userCoordinateIndex = new UserCoordinateIndex(guess, 100);
        assertEquals(70, userCoordinateIndex.convertCoordinateToIndex());
    }

    @Test
    public void addsTenIfRowA() {
        FakeIO io = getFakeIO(asList("A10"));
        String guess = "A10";
        userCoordinateIndex = new UserCoordinateIndex(guess, 100);
        assertEquals(9, userCoordinateIndex.convertCoordinateToIndex());
    }
}