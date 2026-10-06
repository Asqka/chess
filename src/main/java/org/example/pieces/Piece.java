package org.example.pieces;

import org.example.pieces.Board.Board;
import org.example.Color;
import org.example.Coordinate;

import java.util.HashSet;
import java.util.Set;

abstract public class Piece {
    public final Color color;
    public Coordinate coordinate;

    public Piece(Color color, Coordinate coordinate) {
        this.color = color;
        this.coordinate = coordinate;
    }

    //переещение доски
    public Set<Coordinate> getAvailableMoveSquares(Board board) {
        Set<Coordinate> result = new HashSet<>();

        for (CoordinateShift shift : getPieceMoves()) {
            if (coordinate.canShift(shift)) {
                Coordinate newCoordinate = coordinate.shift(shift);
                if (isSquareAvailableForMove(newCoordinate, board)) {
                    result.add(newCoordinate);
                }
            }
        }
        return result;
    }

    protected boolean isSquareAvailableForMove(Coordinate coordinate, Board board) {
        return board.isSquareEmpty(coordinate)
                || board.getPiece(coordinate).color != this.color;
    }

    protected abstract Set<CoordinateShift> getPieceMoves();

    protected Set<CoordinateShift> getPieceAttack() {
        return getPieceMoves();
    }


    public Set<Coordinate> getAttackedSquares(Board board) {
        Set<CoordinateShift> pieceAttacks = getPieceAttack();
        Set<Coordinate> result = new HashSet<>();
        for (CoordinateShift pieceAttack : pieceAttacks) {
            //проверяем можем ли мы сдвинуться на сдвиг
            //то есть чтобы была защита от шаха чтобы не было доступа к атаке
            if (coordinate.canShift(pieceAttack)) {
                Coordinate shiftCoordinate = coordinate.shift(pieceAttack);

                if(isSquareAvailableForAttack(shiftCoordinate,board)){
                    result.add(shiftCoordinate);
                }
            }
        }
        return result;
    }

    protected boolean isSquareAvailableForAttack(Coordinate shiftCoordinate, Board board) {
        return true;
    }
}

