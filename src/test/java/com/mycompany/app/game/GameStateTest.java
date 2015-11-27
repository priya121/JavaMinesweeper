package com.mycompany.app.game;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameStateTest {
    ArrayList<Integer> mineLocations = new ArrayList<Integer>();
    String[] intermediateGrid = new String[]{"•", "1", "•", "•"};
    GameState newGame = new GameState(4, mineLocations);

    @Test
    public void checksGameOver() {
        mineLocations.add(1);
        GameState currentGameState = new GameState(4, mineLocations);
        currentGameState.update(1);
        assertTrue(currentGameState.checkGameOver());
    }

    @Test
    public void returnsFalseIfGameNotOver() {
        mineLocations.add(0);
        GameState currentGameState = new GameState(4, mineLocations);
        currentGameState.update(1);
        assertFalse(newGame.checkGameOver());
    }

    @Test
    public void revealsMineGridIfHit() {
        intermediateGrid = new String[]{"•", "•", "•", "•"};
        String[] expected = new String[]{"•", "*", "•", "•"};
        mineLocations.add(1);
        GameState newGame = new GameState(4, mineLocations);
        assertEquals(expected, newGame.addMineSymbol(mineLocations));
    }

    @Test
    public void revealsIntermediateBoardWithGuesses() {
        intermediateGrid = new String[]{"•", "•", "1", "•"};
        String[] expected = new String[]{"•", "•", "1", "•"};
        mineLocations.add(1);
        GameState newGame = new GameState(4, mineLocations);
        newGame.update(2);
        assertEquals(expected, intermediateGrid);
    }

    @Test
    public void addsMines() {
        GameState newGame = new GameState(4, mineLocations);
        ArrayList<Integer> mineAdditions = new ArrayList<Integer>();
        mineLocations.add(1);
        mineLocations.add(2);
        mineAdditions.add(1);
        mineAdditions.add(2);
        assertEquals(mineLocations, newGame.addMines(mineAdditions));
    }
}
