package com.mycompany.app.game;

import java.util.ArrayList;
import java.util.List;

public class NeighbourMineIncrement {

    public int size;
    public int minesFound = 0;
    private int width;
    private int height;
    private ArrayList<Integer> mineLocations;

    public NeighbourMineIncrement(int size, ArrayList<Integer> mineLocations) {
        this.mineLocations = mineLocations;
        this.size = size;
        this.width = (int) Math.sqrt(this.size);
        this.height = (int) Math.sqrt(this.size);
    }

    public boolean hasMine(int location) {
        return mineLocations.contains(location);
    }

    public int neighbourMinesFound(int location) {
        NeighbourCalculation neighboursAroundLocation = new NeighbourCalculation(size, location);
        minesFound = getTotalMinesFound(location, neighboursAroundLocation, minesFound);
        return minesFound;
    }

    private int getTotalMinesFound(int location, NeighbourCalculation neighboursAroundLocation, int minesFound) {
        if (!hasMine(location)) {
            minesFound = showAllMines(neighboursAroundLocation, minesFound);
        }
        return minesFound;
    }

    private int showAllMines(NeighbourCalculation neighboursAroundLocation, int minesFound) {
        List<Integer> neighbours = neighboursAroundLocation.calculate();
        minesFound = addingIndividualMinesFound(minesFound, neighbours);
        return minesFound;
    }

    private int addingIndividualMinesFound(int minesFound, List<Integer> neighbours) {
        for (int calculatedNeighbour : neighbours) {
            if (mineLocations.contains(calculatedNeighbour)) {
                minesFound += 1;
            }
        }
        return minesFound;
    }
}
