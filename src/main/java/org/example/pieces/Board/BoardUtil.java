package org.example;

import java.util.ArrayList;
import java.util.List;

public class BoardUtil {


    public static List<Coordinate> getDiagonalCoordinate(Coordinate source, Coordinate target) {
        List<Coordinate> result = new ArrayList<>();
        //допущение что клетки лежат на одной диагонали


        //счетчик сдвигов
        int fileShift = source.file.ordinal() < target.file.ordinal() ? 1 : -1;
        int rankShift = source.rank < target.rank ? 1 : -1;

        //проход по эти ячейкам диогонали
        for (
                int fileIndex = source.file.ordinal() + fileShift,
                rank = source.rank + rankShift;

                fileIndex != target.file.ordinal() && rank != target.rank;

                fileIndex += fileShift, rank += rankShift
        ) {
            result.add(new Coordinate(File.values()[fileIndex], rank));
        }

        return result;
    }
    public static List<Coordinate> getVerticalCoordinate(Coordinate source, Coordinate target) {
        List<Coordinate> result = new ArrayList<>();
        //допущение что клетки лежат на одной верткикале

        //счетчик сдвигов
        int rankShift = source.rank < target.rank ? 1 : -1;

        //проход по эти ячейкам диогонали
        for (
                int rank = source.rank + rankShift; rank != target.rank; rank += rankShift) {
            result.add(new Coordinate(source.file, rank));
        }

        return result;
    }
    public static List<Coordinate> getHorizontalCoordinate(Coordinate source, Coordinate target) {
        //допущение что клетки лежат на одной горизонтали
        List<Coordinate> result = new ArrayList<>();

        //счетчик сдвигов
        int fileShift = source.file.ordinal() < target.file.ordinal() ? 1 :-1;

        //проход по эти ячейкам диогонали
        for (
                int fileIndex = source.file.ordinal() + fileShift; fileIndex != target.file.ordinal();fileIndex += fileShift
        ) {
            result.add(new Coordinate(File.values()[fileIndex] ,source.rank));
        }

        return result;
    }

    public static void main(String[] args) {
        List<Coordinate> list = getHorizontalCoordinate(new Coordinate(File.D, 4), new Coordinate(File.H, 4));
        System.out.println("list" + list);
    }


}
