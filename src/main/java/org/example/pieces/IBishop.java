package org.example.pieces;

import java.util.HashSet;
import java.util.Set;

public interface IBishop {
    default  Set<CoordinateShift> getBishopMoves(){
        Set<CoordinateShift> result = new HashSet<>();
        //одля перемещения  яот а1 до h8(от слева внищ до правого вернхгнего угла )
        for (int i = -7; i <7 ; i++) {
            if(i==0)continue;

            result.add(new CoordinateShift(i,i));
        }
        //противоположная диагональ
        for (int i = -7; i <7 ; i++) {
            if(i==0)continue;

            result.add(new CoordinateShift(i,-i));
        }
        return result;
    }
}
