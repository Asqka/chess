package org.example.pieces;

import org.example.Color;
import org.example.Coordinate;

import java.util.Set;

public class Queen extends LongRangePiece implements  IRook,IBishop{
    public Queen(Color color, Coordinate coordinate) {
        super(color, coordinate);
    }

    @Override
    protected Set<CoordinateShift> getPieceMoves() {
        Set<CoordinateShift> moves = getBishopMoves();
        moves.addAll(getRookMoves());
        return moves;
    }
}
