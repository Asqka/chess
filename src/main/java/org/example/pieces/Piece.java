package org.example;

abstract public class Piece {
    public  final Color color;
    public  Coordinate coordinate;

    public Piece(Color color, Coordinate coordinate) {
        this.color = color;
        this.coordinate = coordinate;
    }
}

