package org.example.pieces;

import org.example.Color;
import org.example.Coordinate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Knight extends Piece {
    public Knight(Color color, Coordinate coordinate) {
        super(color, coordinate);
    }

    @Override
    protected Set<CoordinateShift> getPieceMoves() {
        return new HashSet<>(Arrays.asList(
                new CoordinateShift(1,2),
                new CoordinateShift(2,1),

                new CoordinateShift(2,-1),
                new CoordinateShift(1,-2),

                new CoordinateShift(-2,-1),
                new CoordinateShift(-1,-2),

                new CoordinateShift(-2,1),
                new CoordinateShift(-1,2)


        ));
    }
}
