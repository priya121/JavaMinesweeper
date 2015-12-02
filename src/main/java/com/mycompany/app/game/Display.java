package com.mycompany.app.game;

import java.util.ArrayList;
import java.util.List;

public class Display {
    private static IO io;
    private static ArrayList<Integer> mineLocations;
    private static List uncheckedList;
    private int size;
    private String[] columnNumber = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private String[] rowLetter = new String[]{"A  ", "B  ", "C  ", "D  ", "E  ", "F  ", "G  ", "H  ", "I  ", "J  ", "K  "};
    private int counter = 1;
    private int index;

    public Display(int size) {
        this.io = new ConsoleIO(System.in, System.out);
        this.size = size;
        this.mineLocations = addMines(size);
    }

    public ArrayList<Integer> addMines(int size) {
        RandomizeNumber randomNumber = new RandomizeNumber();
        mineLocations = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            mineLocations.add(randomNumber.numberGenerator(size));
        }
        return mineLocations;
    }

    public void showInitialState(Display game, GameState newGameState) {
        io.showMessage(game.convertToStringDisplay(newGameState.getCurrentState()));
        io.showMessage("Enter a coordinate: \n");
    }

    public void gameLoop() {
        GameState gameState = new GameState(size, mineLocations);
        while (!gameState.checkGameOver()) {
            nextUserMove(gameState);
        }
        io.showMessage(convertToStringDisplay(gameState.getCurrentState()));
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
        UserCoordinate locationIndex = new UserCoordinate(guessedString, size);
        uncheckedList = currentGameState.initializeUncheckedNeighbours();
        //RecursiveReveal recurse = new RecursiveReveal(100, mineLocations, uncheckedList);
        currentGameState.update(index = locationIndex.convertCoordinateToIndex());
    }

    public String convertToStringDisplay(String[] array) {
        String grid = addColumnNumbers();
        grid = addRowLetters(array, counter, grid);
        return removeLastElement(grid);
    }

    private String addRowLetters(String[] array, int counter, String grid) {
        grid += rowLetter[0];
        grid = RowLettersFromSecondRowOnwards(array, counter, grid);
        return grid;
    }

    private String RowLettersFromSecondRowOnwards(String[] array, int counter, String grid) {
        for (int i = 0; i < array.length; i++) {
            grid += (array[i] + " ");
            if ((i + 1) % Math.sqrt(size) == 0) {
                grid += "\n" + (rowLetter[counter++]);
            }
        }
        return grid;
    }

    private String addColumnNumbers() {
        String grid = "   ";
        grid = addIndividualColumnNumbers(grid);
        grid += "\n";
        return grid;
    }

    private String addIndividualColumnNumbers(String grid) {
        for (int n = 0; n < Math.sqrt(size); n++) {
            grid += columnNumber[n] + " ";
        }
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
