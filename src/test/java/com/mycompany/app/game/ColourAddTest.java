package com.mycompany.app.game;

import org.junit.Test;

public class ColourAddTest {
    @Test
    public void addsColoursToEmptyBoard() {
        ColourAdd colourEmptyCells = new ColourAdd();
        String[] grid = new String[]{"•","•","•","•"};
        colourEmptyCells.colourUnrevealed(grid);
    }
}
