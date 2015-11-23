package com.mycompany.app.resources;

import java.util.LinkedList;
import java.util.List;

public class FakeIO implements IO {
    private LinkedList<String> coordinates;

    public FakeIO(List<String> guessedCoordinates) {
        this.coordinates = new LinkedList<String>(guessedCoordinates);
    }

    @Override
    public String takeInput() {
        return String.valueOf(coordinates.pop());
    }

    @Override
    public String showGrid() {
        return null;
    }
}
