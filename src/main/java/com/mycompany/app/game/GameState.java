package com.mycompany.app.game;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    private final int size;
    private NeighbourMines game;
    private ArrayList<Integer> mineLocations;
    private String[] gridArray;

    public enum Status {
        MINE("*"),
        NOT_REVEALED("•");

        private String symbol;

        Status(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }
    }

    public GameState(int size, ArrayList<Integer> mineLocations) {
        this.size = size;
        this.mineLocations = mineLocations;
        this.gridArray = buildInitialGrid();
    }

    public boolean checkGameOver() {
        for (String individualElement : gridArray) {
            if (individualElement.equals(Status.MINE.getSymbol())) return true;
        }
        return false;
    }

    private String[] buildInitialGrid() {
        String[] initialState = new String[size];
        for (int i = 0; i < size; i++) initialState[i] = String.valueOf(Status.NOT_REVEALED.getSymbol());
        return initialState;
    }

    public void update(int guessedIndex) {
        this.game = new NeighbourMines(size, mineLocations);
        if (mineLocations.contains(guessedIndex)) addMineSymbol(mineLocations);
        else gridArray[guessedIndex] = String.valueOf(game.neighbourMinesFound(guessedIndex));
    }

    public String[] addMineSymbol(ArrayList<Integer> mineLocations) {
        for (int j = 0; j < mineLocations.size(); j++) {
            gridArray[mineLocations.get(j)] = String.valueOf(Status.MINE.symbol);
        }
        return gridArray;
    }

    public List<Integer> addMines(ArrayList<Integer> mineAdditions) {
        for (int i = 0; i < mineAdditions.size(); i++) {
            mineLocations.add(mineAdditions.get(i));
        }
        return mineLocations;
    }

    public String[] getCurrentState() {
        return gridArray;
    }
}
