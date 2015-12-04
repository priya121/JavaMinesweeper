package com.mycompany.app.game;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class UserCoordinateTest {
    private UserCoordinate userCoordinate;

    @Test
    public void userInputsCoordinateInsteadOfIndex() {
        String guess = "A1";
        userCoordinate = new UserCoordinate(guess, 4);
        assertEquals(0, userCoordinate.convertCoordinateToIndex());
    }

    @Test
    public void anotherUserInputsCoordinateInsteadOfIndex() {
        String guess = "B1";
        userCoordinate = new UserCoordinate(guess, 4);
        assertEquals(2, userCoordinate.convertCoordinateToIndex());
    }

    @Test
    public void takesInputWithCCoordinate() {
        String guess = "C3";
        userCoordinate = new UserCoordinate(guess, 9);
        assertEquals(8, userCoordinate.convertCoordinateToIndex());
    }

    @Test
    public void takesInputWithECoordinate() {
        String guess = "E1";
        userCoordinate = new UserCoordinate(guess, 25);
        assertEquals(20, userCoordinate.convertCoordinateToIndex());
    }

    @Test
    public void takesInputWithHCoordinate() {
        String guess = "H6";
        userCoordinate = new UserCoordinate(guess, 100);
        assertEquals(75, userCoordinate.convertCoordinateToIndex());
    }

    @Test
    public void addsTwentyIfRowE() {
        String guess = "H1";
        userCoordinate = new UserCoordinate(guess, 100);
        assertEquals(70, userCoordinate.convertCoordinateToIndex());
    }

    @Test
    public void addsTenIfRowA() {
        String guess = "A10";
        userCoordinate = new UserCoordinate(guess, 100);
        assertEquals(9, userCoordinate.convertCoordinateToIndex());
    }
}