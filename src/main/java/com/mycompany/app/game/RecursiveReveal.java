package com.mycompany.app.game;

import java.util.ArrayList;
import java.util.List;

public class RecursiveReveal {
    private ArrayList<Integer> mineLocations;
    private List<Integer> uncheckedList;
    private int size;

    public RecursiveReveal(int size, ArrayList<Integer> mineLocations, List<Integer> uncheckedList) {
        this.size = size;
        this.mineLocations = mineLocations;
        this.uncheckedList = uncheckedList;
    }

    public List<Integer> getNeighbours(int position) {
        NeighboursCalculation neighbourCalculation = new NeighboursCalculation(size, position);
        return neighbourCalculation.calculate();
    }

    public void checkIfRecurse(int position, GameState gameState) {
        NeighbourMineIncrement neighbourMines = new NeighbourMineIncrement(size, mineLocations);
        if (neighbourMines.neighbourMinesFound(position) > 0) {
            gameState.update(position);
        }
        else {
            recursiveReveal(position, gameState);
        }
    }

    public void recursiveReveal(int position, GameState gameState) {
        List<Integer> neighboursOfCellChosen = getNeighbours(position);

        for (Integer neighbourCellIndex : neighboursOfCellChosen) {
            NeighbourMineIncrement neighbourMines = new NeighbourMineIncrement(size, mineLocations);
            boolean noMinesFound = !neighbourMines.hasMine(neighbourCellIndex);

            if (noMinesFound) {
                gameState.update(position);
                gameState.update(neighbourCellIndex);

                if (neighbourMines.neighbourMinesFound(neighbourCellIndex) == 0 && uncheckedList.contains(neighbourCellIndex)) {
                        removeVisitedCell(neighbourCellIndex);
                        recursiveReveal(neighbourCellIndex, gameState);
                    }
                }
            }
    }

    private void removeVisitedCell(int neighbourCellIndex) {
        for (int j = 0; j < uncheckedList.size(); j++) {
            if (uncheckedList.get(j) == neighbourCellIndex) {
                uncheckedList.remove(j);
            }
        }
    }
}

