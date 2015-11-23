package com.mycompany.app.resources;

public class UserCoordinateIndex {
    int size;
    char[] coordinates;

    public UserCoordinateIndex(char[] coordinates, int size) {
        this.coordinates = coordinates;
        this.size = size;
    }

    public int convertCoordinateToIndex() {
        int row = coordinates[0] - 'A';
        if (coordinates.length > 2) {
            int column = Character.getNumericValue(coordinates[1] + coordinates[2]);
            return converts(row, column);
        }
        int column = Character.getNumericValue(coordinates[1]);
        return converts(row, column);
    }

    public int converts(int row, int column) {
        return (int) (row * (Math.sqrt(size)) + (column - 1));
    }
}
