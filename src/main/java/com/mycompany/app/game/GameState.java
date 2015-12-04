package com.mycompany.app.game;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    private final int size;
    private NeighbourMineIncrement game;
    private ArrayList<Integer> mineLocations;
    private String[] gridArray;
    private List<Integer> uncheckedNeighbours;

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
        this.uncheckedNeighbours = initializeUncheckedNeighbours();
    }

    public boolean checkGameOver() {
        for (String individualElement : gridArray) {
            if (individualElement.equals(Status.MINE.getSymbol())) return true;
        }
        return false;
    }

    private String[] buildInitialGrid() {
        String[] initialState = new String[size];
        for (int i = 0; i < size; i++) {
            initialState[i] = ANSI_BLUE + String.valueOf(Status.NOT_REVEALED.getSymbol()) + ANSI_RESET;
        }
        return initialState;
    }

    public void update(int guessedIndex) {
        this.game = new NeighbourMineIncrement(size, mineLocations);
        if (mineLocations.contains(guessedIndex)) addMineSymbols(mineLocations);
        else gridArray[guessedIndex] = ANSI_GREEN + String.valueOf(game.neighbourMinesFound(guessedIndex)) + ANSI_RESET;
            removeIndexFromUnchecked(guessedIndex);
    }

    public String[] addMineSymbols(ArrayList<Integer> mineLocations) {
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

    public List<Integer> initializeUncheckedNeighbours() {
        uncheckedNeighbours = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            uncheckedNeighbours.add(i);
        }
        return uncheckedNeighbours;
    }

    public void removeIndexFromUnchecked(int guessedIndex) {
            if (uncheckedNeighbours.contains(guessedIndex)) {
                int index = uncheckedNeighbours.indexOf(guessedIndex);
                uncheckedNeighbours.remove(index);
        }
    }
}
