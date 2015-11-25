package com.mycompany.app.game;

import java.util.ArrayList;

public class Display {
    private static IO io = new ConsoleIO(System.in, System.out);
    private static ArrayList<Integer> mineLocations;
    private int size;
    private String[] columnNumber = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private String[] rowLetter = new String[]{"A  ", "B  ", "C  ", "D  ", "E  ", "F  ", "G  ", "H  ", "I  ", "J  ", "K  "};
    private int counter = 1;
    private int index;

    public Display(IO io, ArrayList<Integer> mineLocations, int size) {
        this.io = io;
        this.mineLocations = addMines();
        this.size = size;
    }

    public static void main(String args[]) {
        Display game = new Display(io, mineLocations, 100);
        GameState newGameState = new GameState(game.size, mineLocations);
        showInitialState(game, newGameState);
        game.gameLoop();
    }

    private static ArrayList<Integer> addMines() {
        mineLocations = new ArrayList<Integer>();
        mineLocations.add(1);
        mineLocations.add(10);
        return mineLocations;
    }

    private static void showInitialState(Display game, GameState newGameState) {
        io.showMessage(game.convertToStringDisplay(newGameState.buildInitialGrid()));
        io.showMessage("Enter a coordinate: \n");
    }

    public void gameLoop() {
        GameState currentGameState = new GameState(size, mineLocations);
        while (!currentGameState.checkGameOver()) {
            nextUserMove(currentGameState);
        }
        io.showMessage(convertToStringDisplay(currentGameState.getCurrentState()));
    }

    private void nextUserMove(GameState currentGameState) {
        getUserCoordinate(currentGameState);
        clearScreen();
        showUserPrompt(currentGameState);
    }

    private void showUserPrompt(GameState currentGameState) {
        io.showMessage(convertToStringDisplay(currentGameState.getCurrentState()));
        io.showMessage("Enter a coordinate: \n");
    }

    private void getUserCoordinate(GameState currentGameState) {
        String guessedString = io.takeInput();
        UserCoordinateIndex locationIndex = new UserCoordinateIndex(guessedString, size);
        currentGameState.update(index = locationIndex.convertCoordinateToIndex());
    }

    public String convertToStringDisplay(String[] array) {
        String grid = addColumnNumbers();
        grid = addRowLetters(array, counter, grid);
        return removeLastElement(grid);
    }

    private String addRowLetters(String[] array, int counter, String grid) {
        grid += rowLetter[0];
        for (int i = 0; i < array.length; i++) {
            grid += (array[i] + " ");
            if ((i + 1) % Math.sqrt(size) == 0) {
                grid += "\n";
                grid += (rowLetter[counter++]);
            }
        }
        return grid;
    }

    private String addColumnNumbers() {
        String grid = "   ";
        for (int n = 0; n < Math.sqrt(size); n++) {
            grid += columnNumber[n] + " ";
        }
        grid += "\n";
        return grid;
    }

    private String removeLastElement(String grid) {
        String newGrid = grid.substring(0, grid.length() - 5);
        return newGrid;
    }

    public void clearScreen() {
        String ESC = "\033[2J\033[1;1H";
        System.out.println(ESC);
        System.out.flush();
    }
}
