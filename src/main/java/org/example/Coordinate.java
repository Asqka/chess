package org.example;

import org.example.pieces.Board.Board;
import org.example.pieces.CoordinateShift;

public class Coordinate {
    public final File file;
    public final Integer rank;


    public Coordinate(File file, Integer rank) {
        this.file = file;
        this.rank = rank;
    }


    private boolean isSquareAvailableForMove(Coordinate coordinate, Board board, Color color) {
        return board.isSquareEmpty(coordinate) || board.getPiece(coordinate).color != color;
    }


    public Coordinate shift(CoordinateShift shift) {
        return new Coordinate(File.values()[this.file.ordinal() + shift.fileShift], this.rank + shift.rankShift);
    }

    public boolean canShift(CoordinateShift shift) {
        int f = file.ordinal() + shift.fileShift;
        int r = rank + shift.rankShift;

        if ((f < 0) || (f > 7)) return false;
        if ((r < 1) || (r > 8)) return false;

        return true;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;
        if (file != that.file) return false;
        return rank.equals(that.rank);

    }

    @Override
    public int hashCode() {
        int result = file.hashCode();
        result = 31 * result + rank.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return file + String.valueOf(rank);

    }
}
