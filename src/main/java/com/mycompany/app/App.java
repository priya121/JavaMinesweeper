package com.mycompany.app;

import com.mycompany.app.game.Game;

public class App
{
    public static void main(String args[]) {
            Game game = new Game(100);
            game.gameLoop(game);
        }
}
