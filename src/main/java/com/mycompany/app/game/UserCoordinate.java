package com.mycompany.app.game;

public class UserCoordinate {
    int size;
    String coordinates;

    public UserCoordinate(String coordinates, int size) {
        this.coordinates = coordinates;
        this.size = size;
    }

    public int convertCoordinateToIndex() {
        int row = coordinates.substring(0,1).charAt(0) - 'A';
        int column = Integer.valueOf(coordinates.substring(1));
        return converts(row, column);
    }

    public int converts(int row, int column) {
        return (int) (row * (Math.sqrt(size)) + (column - 1));
    }
}
