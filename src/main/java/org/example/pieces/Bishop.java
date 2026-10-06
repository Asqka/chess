package org.example.pieces;

import org.example.Color;
import org.example.Coordinate;

import java.util.Set;

public class Bishop extends LongRangePiece implements IBishop {
    public Bishop(Color color, Coordinate coordinate) {
        super(color, coordinate);
    }

    @Override
    //для сдвигов по диагонали
    protected Set<CoordinateShift> getPieceMoves() {
          return getBishopMoves();
    }


}
