package com.mycompany.app.game;

public class DisplayGrid {
    private String[] columnNumber = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private String[] rowLetter = new String[]{"A  ", "B  ", "C  ", "D  ", "E  ", "F  ", "G  ", "H  ", "I  ", "J  ", "K"};
    private int counter = 1;
    private int size;

   public DisplayGrid(int size) {
       this.size = size;
   }

    public String convertToStringDisplay(String[] array) {
        String grid = addColumnNumbers();
        grid = addRowLetters(array, counter, grid);
        return removeLastElement(grid);
    }

    private String addRowLetters(String[] array, int counter, String grid) {
        grid +=rowLetter[0];
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
        return grid.substring(0, grid.length() - 6);
    }

    public void clearScreen() {
        String ESC = "\033[2J\033[1;1H";
        System.out.println(ESC);
        System.out.flush();
    }
}
