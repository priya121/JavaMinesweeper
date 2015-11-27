package com.mycompany.app.game;

import java.util.List;

public class RecursiveReveal {
    private final List<String> board;
    private final int startingPosition;

    public RecursiveReveal(int startingPosition, List<String> board) {
        this.startingPosition = startingPosition;
        this.board = board;
    }

    public List<Integer> getNeighbours(int position) {
        NeighbourCalculation neighbourCalculation = new NeighbourCalculation(board.size(), position);
        return neighbourCalculation.calculate();
    }
}
