package com.mycompany.app;

import com.mycompany.app.game.Display;
import com.mycompany.app.game.GameState;

import java.util.ArrayList;

public class App
{
    public static void main(String args[]) {
            Display game = new Display(100);
            ArrayList<Integer> mineLocations = game.addMines(100);
            GameState newGameState = new GameState(100, mineLocations);
            game.showInitialState(game, newGameState);
            game.gameLoop();
        }
}
