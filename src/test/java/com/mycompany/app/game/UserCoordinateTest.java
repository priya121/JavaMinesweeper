package com.mycompany.app.game;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertEquals;

public class UserCoordinateTest {
    private UserCoordinate userCoordinate;

    private FakeIO getFakeIO(List<String> numbers) {
        return new FakeIO(numbers);
    }

    @Test
    public void userInputsCoordinateInsteadOfIndex() {
        FakeIO io = getFakeIO(asList("A1"));
        String guess = "A1";
        userCoordinate = new UserCoordinate(guess, 4);
        assertEquals(0, userCoordinate.convertCoordinateToIndex());
    }

    @Test
    public void anotherUserInputsCoordinateInsteadOfIndex() {
        FakeIO io = getFakeIO(asList("B1"));
        String guess = "B1";
        userCoordinate = new UserCoordinate(guess, 4);
        assertEquals(2, userCoordinate.convertCoordinateToIndex());
    }

    @Test
    public void takesInputWithCCoordinate() {
        FakeIO io = getFakeIO(asList("C3"));
        String guess = "C3";
        userCoordinate = new UserCoordinate(guess, 9);
        assertEquals(8, userCoordinate.convertCoordinateToIndex());
    }

    @Test
    public void takesInputWithECoordinate() {
        FakeIO io = getFakeIO(asList("E1"));
        String guess = "E1";
        userCoordinate = new UserCoordinate(guess, 25);
        assertEquals(20, userCoordinate.convertCoordinateToIndex());
    }

    @Test
    public void takesInputWithHCoordinate() {
        FakeIO io = getFakeIO(asList("H6"));
        String guess = "H6";
        userCoordinate = new UserCoordinate(guess, 100);
        assertEquals(75, userCoordinate.convertCoordinateToIndex());
    }

    @Test
    public void addsTwentyIfRowE() {
        FakeIO io = getFakeIO(asList("H1"));
        String guess = "H1";
        userCoordinate = new UserCoordinate(guess, 100);
        assertEquals(70, userCoordinate.convertCoordinateToIndex());
    }

    @Test
    public void addsTenIfRowA() {
        FakeIO io = getFakeIO(asList("A10"));
        String guess = "A10";
        userCoordinate = new UserCoordinate(guess, 100);
        assertEquals(9, userCoordinate.convertCoordinateToIndex());
    }
}