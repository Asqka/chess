package org.example.pieces;

import java.util.HashSet;
import java.util.Set;

public interface IRook {
    default Set<CoordinateShift> getRookMoves() {
        Set<CoordinateShift> result = new HashSet<>();
        //справа на лево
        for (int i = -7; i <=7 ; i++) {
            if(i==0)continue;

            result.add(new CoordinateShift(i,0));
        }
        //снизу вверх
        for (int i = -7; i <7 ; i++) {
            if(i==0)continue;

            result.add(new CoordinateShift(0,i));
        }


        return  result;
    }
}
