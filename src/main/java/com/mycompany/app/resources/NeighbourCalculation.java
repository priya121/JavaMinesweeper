package com.mycompany.app.resources;

import java.util.ArrayList;
import java.util.List;

public class NeighbourCalculation {
    int width;
    int height;
    int location;
    ArrayList<Integer> neighbours;

    public NeighbourCalculation(int size, int location) {
        this.width = (int) Math.sqrt(size);
        this.height = (int) Math.sqrt(size);
        this.location = location;
    }

    public List<Integer> calculate() {
        this.neighbours = new ArrayList<Integer>();
        int xLocation = (location % width);
        int yLocation = (location / height);

        anyTopRowNeighbours(xLocation, yLocation);
        anyEdgeColumnNeighbours(xLocation);
        anyBottomNeighbours(xLocation, yLocation);

        return neighbours;
    }

    private void anyBottomNeighbours(int xLocation, int yLocation) {
        notBottomLeftCorner(location, xLocation, yLocation);
        notBottomRow(location, yLocation);
        notBottomRightCorner(location, xLocation, yLocation);
    }

    private void anyEdgeColumnNeighbours(int xLocation) {
        notFirstColumn(xLocation, location - 1);
        notLastColumn(location, xLocation);
    }

    private void anyTopRowNeighbours(int xLocation, int yLocation) {
        notTopLeftCorner(location, xLocation);
        notFirstRow(location, yLocation);
        notTopRightCorner(location, xLocation, yLocation);
    }

    private void notBottomRightCorner(int location, int xLocation, int yLocation) {
        if (xLocation < width - 1 && yLocation < height - 1)
            neighbours.add(location + (width + 1));
    }

    private void notBottomRow(int location, int yLocation) {
        if (yLocation < (height - 1))
            neighbours.add(location + width);
    }

    private void notBottomLeftCorner(int location, int xLocation, int yLocation) {
        if (xLocation > 0 && (yLocation < (height - 1)))
            neighbours.add(location + (width - 1));
    }

    private void notLastColumn(int location, int xLocation) {
        if (xLocation < (width - 1))
            neighbours.add(location + 1);
    }

    private void notFirstColumn(int xLocation, int location) {
        if (xLocation > 0)
            neighbours.add(location);
    }

    private void notTopRightCorner(int location, int xLocation, int yLocation) {
        if (xLocation < (width - 1) && yLocation > 0)
            neighbours.add(location - (width - 1));
    }

    private void notFirstRow(int location, int yLocation) {
        if (yLocation > 0)
            neighbours.add(((location - (width))));
    }

    private void notTopLeftCorner(int location, int xLocation) {
        if (xLocation > 0 && location > 1)
            neighbours.add((location - (width) - 1));
    }
}


