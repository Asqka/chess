package org.example.pieces;

import org.example.Color;
import org.example.Coordinate;

import java.util.Set;

public class Rook extends LongRangePiece implements IRook {
    public Rook(Color color, Coordinate coordinate) {
        super(color, coordinate);
    }

    @Override
    protected Set<CoordinateShift> getPieceMoves() {
        return getRookMoves();
    }



}
