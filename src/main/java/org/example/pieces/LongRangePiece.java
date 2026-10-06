package org.example.pieces;

import org.example.pieces.Board.Board;
import org.example.pieces.Board.BoardUtil;
import org.example.Color;
import org.example.Coordinate;

import java.util.List;

public abstract class LongRangePiece extends Piece {
    public LongRangePiece(Color color, Coordinate coordinate) {
        super(color, coordinate);
    }

    //объеденяем логику слона ферзя и  ладьи так как они имеют схожества и оба не могут перепрыгнуть через фигуру и оба дальнобойние
    protected boolean isSquareAvailableForMove(Coordinate coordinate, Board board) {
        boolean result = super.isSquareAvailableForMove(coordinate, board);
        if (result) {
            return  isSquareAvailableForAttack(coordinate, board);
        } else {
            return false;
        }
    }


    @Override
    protected boolean isSquareAvailableForAttack(Coordinate coordinate, Board board) {
        List<Coordinate> coordinatesBetween;
        if (this.coordinate.file == coordinate.file) {
            coordinatesBetween = BoardUtil.getVerticalCoordinate(this.coordinate, coordinate);
        } else if (this.coordinate.rank.equals(coordinate.rank)) {
            coordinatesBetween = BoardUtil.getHorizontalCoordinate(this.coordinate, coordinate);
        } else {
            coordinatesBetween = BoardUtil.getDiagonalCoordinate(this.coordinate, coordinate);
        }

        for (Coordinate c : coordinatesBetween) {
            //если есть на диоганале фигура то ход  заблокирвоан
            if (!board.isSquareEmpty(c)) {
                return false;
            }
        }

        return true;
    }
}

