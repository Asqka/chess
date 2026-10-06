package org.example.pieces;

import org.example.pieces.Board.Board;
import org.example.Color;
import org.example.Coordinate;

import java.util.HashSet;
import java.util.Set;

public class Pawn extends Piece {
    public Pawn(Color color, Coordinate coordinate) {
        super(color, coordinate);
    }

    @Override
    protected Set<CoordinateShift> getPieceMoves() {
        Set<CoordinateShift> result = new HashSet<>();

        if (color == Color.WHITE) {
            result.add(new CoordinateShift(0, 1));

            if (coordinate.rank == 2) {
                result.add(new CoordinateShift(0, 2));
            }
            result.add(new CoordinateShift(-1, 1));
            result.add(new CoordinateShift(1,1 ));

        } else {
            result.add(new CoordinateShift(0, -1));
            if (coordinate.rank == 7) {
                result.add(new CoordinateShift(0, -2));
            }
            result.add(new CoordinateShift(-1, -1));
            result.add(new CoordinateShift(1,-1 ));
        }

        return result;

    }

    @Override
    protected Set<CoordinateShift> getPieceAttack() {
        Set<CoordinateShift> result = new HashSet<>();
        if(color==Color.WHITE){
            result.add(new CoordinateShift(-1, 1));
            result.add(new CoordinateShift(1,1 ));
        }else {
            result.add(new CoordinateShift(-1, -1));
            result.add(new CoordinateShift(1,-1 ));
        }
        return  result;

    }

    @Override
    protected boolean isSquareAvailableForMove(Coordinate coordinate, Board board) {
        if(this.coordinate.file==coordinate.file){
            return board.isSquareEmpty(coordinate);
        }else {
            if(board.isSquareEmpty(coordinate)){
                return false;
            }else {
                return board.getPiece(coordinate).color!=color;
            }
        }
    }
}
