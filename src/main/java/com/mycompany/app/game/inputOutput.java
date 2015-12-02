package com.mycompany.app.game;


public class inputOutput {
    private static IO io = new ConsoleIO(System.in, System.out);
    private final int size;
    private int index;

    public inputOutput(IO io, int size) {
        this.io = io;
        this.size = size;
    }

    private static void showInitialState(Display game, GameState newGameState) {
        io.showMessage(game.convertToStringDisplay(newGameState.getCurrentState()));
        io.showMessage("Enter a coordinate: \n");
    }

    private void getUserCoordinate(GameState currentGameState) {
        String guessedString = io.takeInput();
        UserCoordinate locationIndex = new UserCoordinate(guessedString, size);
        currentGameState.update(index = locationIndex.convertCoordinateToIndex());
    }

}
