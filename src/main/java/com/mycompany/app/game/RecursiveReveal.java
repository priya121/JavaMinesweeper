package com.mycompany.app.game;

import java.util.ArrayList;
import java.util.List;

public class RecursiveReveal {
    private List<String> board;
    private ArrayList<Integer> mineLocations;
    private List<Integer> uncheckedList;
    private int size;
    private NeighbourMineIncrement game;

    public RecursiveReveal(int size, ArrayList<Integer> mineLocations, List<Integer> uncheckedList) {
        this.size = size;
        this.mineLocations = mineLocations;
        this.uncheckedList = uncheckedList;
    }

    public List<Integer> getNeighbours(int position) {
        NeighboursCalculation neighbourCalculation = new NeighboursCalculation(size, position);
        return neighbourCalculation.calculate();
    }

    public GameState recursiveReveal(int position, GameState gameState) {
        List<Integer> neighboursOfCellChosen = getNeighbours(position);
        for (Integer neighbourCellIndex : neighboursOfCellChosen) {

            NeighbourMineIncrement game = new NeighbourMineIncrement(size, mineLocations);
            int amountOfMines = game.neighbourMinesFound(neighbourCellIndex);
            if (!game.hasMine(neighbourCellIndex)) {
                gameState.update(neighbourCellIndex);
                if (amountOfMines == 0 && uncheckedList.contains(neighbourCellIndex)) {
                    removeVisitedCell(neighbourCellIndex);
                    recursiveReveal(neighbourCellIndex, gameState);
                }
            }
        }
        return gameState;
    }

    private void removeVisitedCell(int neighbourCellIndex) {
        for (int j = 0; j < uncheckedList.size(); j++) {
            if (uncheckedList.get(j) == neighbourCellIndex) {
                uncheckedList.remove(j);
            }
        }
    }
}

