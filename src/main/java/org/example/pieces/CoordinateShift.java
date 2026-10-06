package org.example.pieces;

import org.example.Coordinate;

public class CoordinateShift {
    public final int fileShift;
    public final int rankShift;

    public CoordinateShift(int fileShift, int rankShift) {
        this.fileShift = fileShift;
        this.rankShift = rankShift;
    }
}
