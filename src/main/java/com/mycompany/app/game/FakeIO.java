package com.mycompany.app.game;

import java.util.LinkedList;
import java.util.List;

public class FakeIO implements IO {
    private LinkedList<String> coordinates;

    public FakeIO(List<String> guessedCoordinates) {
        this.coordinates = new LinkedList<String>(guessedCoordinates);
    }

    @Override
    public String takeInput() {
        return coordinates.pop();
    }

    @Override
    public void showGrid(String[] message) {
        System.out.println(message);
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}
