package com.mycompany.app.game;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    private IO io;
    private DisplayGrid grid;
    private ArrayList<Integer> mineLocations;
    private List<Integer> uncheckedList;
    private int size;
    private String[] columnNumber = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private String[] rowLetter = new String[]{"A  ", "B  ", "C  ", "D  ", "E  ", "F  ", "G  ", "H  ", "I  ", "J  "};
    private int counter = 1;
    private int index;

    public Game(int size) {
        this.io = new ConsoleIO(System.in, System.out);
        this.size = size;
        this.mineLocations = addMines(size);
        this.uncheckedList = initializeUncheckedNeighbours();
        this.grid = new DisplayGrid(size);
    }

    public ArrayList<Integer> addMines(int size) {
        RandomizeNumber randomNumber = new RandomizeNumber();
        mineLocations = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            mineLocations.add(randomNumber.numberGenerator(size));
        }
        return mineLocations;
    }

    public List<Integer> initializeUncheckedNeighbours() {
        uncheckedList = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            uncheckedList.add(i);
        }
        return uncheckedList;
    }

    public void showInitialState(GameState newGameState) {
        io.showMessage(grid.convertToStringDisplay(newGameState.getCurrentState()));
        io.showMessage(ANSI_RED + "\nEnter a coordinate: \n" + ANSI_RESET);
    }

    public void gameLoop() {
        ArrayList<Integer> mineLocations = this.addMines(100);
        GameState gameState = new GameState(size, mineLocations);
        this.showInitialState(gameState);
        while (!gameState.checkGameOver()) {
            nextUserMove(gameState);
        }
        gameOver(gameState);
        askIfReplayGame();
    }

    private void gameOver(GameState gameState) {
        grid.clearScreen();
        io.showMessage(grid.convertToStringDisplay(gameState.getCurrentState()));
        io.showMessage(ANSI_RESET + "\nYou Hit a Mine! Game Over!\n\nWould you like to play again? (Y/N)");
    }

    private void askIfReplayGame() {
        if (io.takeInput().equals("Y")) {
            grid.clearScreen();
            gameLoop();
        }
    }

    private void nextUserMove(GameState currentGameState) {
        getUserCoordinate(currentGameState);
        grid.clearScreen();
        showUserPrompt(currentGameState);
    }

    private void showUserPrompt(GameState currentGameState) {
        io.showMessage(grid.convertToStringDisplay(currentGameState.getCurrentState()));
        io.showMessage(ANSI_RED + "\nEnter a coordinate: \n" + ANSI_RESET);
    }

    private void getUserCoordinate(GameState currentGameState) {
        String guessedString = io.takeInput();
        UserCoordinate locationIndex = new UserCoordinate(guessedString, size);
        RecursiveReveal recurse = new RecursiveReveal(100, mineLocations, uncheckedList);
        recurse.checkIfRecurse(index = locationIndex.convertCoordinateToIndex(), currentGameState);
    }
}

