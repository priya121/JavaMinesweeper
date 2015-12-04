package com.mycompany.app.game;

import java.util.ArrayList;

public class ColourAdd {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    ArrayList<Integer> mineLocations = new ArrayList<Integer>();


    public String[] colourUnrevealed(String[] unRevealed) {
        for (int i = 0; i < unRevealed.length; i++) {
            if (unRevealed[i].equals("•")) ;
            unRevealed[i] = ANSI_CYAN + unRevealed[i];
        }
        return unRevealed;
    }
}

