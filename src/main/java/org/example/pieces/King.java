package org.example.pieces;

import org.example.pieces.Board.Board;
import org.example.Color;
import org.example.Coordinate;

import java.util.HashSet;
import java.util.Set;

public class King extends Piece {
    public King(Color color, Coordinate coordinate) {
        super(color, coordinate);
    }

    @Override
    protected Set<CoordinateShift> getPieceMoves() {
        //хуказали чтот король может вокргу себя только по 1 во всех направлениях
        Set<CoordinateShift> result = new HashSet<>();
        for (int fileShift = -1; fileShift <= 1; fileShift++) {
            for (int rankShift = -1; rankShift <= 1; rankShift++) {
                if((fileShift==0)&&(rankShift==0)){
                    continue;
                }
                result.add(new CoordinateShift(fileShift,rankShift));
            }
        }

        return result;

    }
//проверка занята ли клетка чтобы сделать ход
    @Override
    protected boolean isSquareAvailableForMove(Coordinate coordinate, Board board) {
       boolean result = super.isSquareAvailableForMove(coordinate, board);

       if(result){
           //проверка
           return !board.isSquareAttackByColor(coordinate,color.opposite());
       }
       return false;
    }
}
