package org.example.pieces.Board;

import org.example.Color;
import org.example.Coordinate;
import org.example.File;
import org.example.pieces.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
//file=вретикаль

public class Board {
    HashMap<Coordinate, Piece> pieces = new HashMap<>();

    public void setPieces(Coordinate coordinate, Piece piece) {
        piece.coordinate = coordinate;
        pieces.put(coordinate, piece);
    }

    public Piece getPice(Coordinate coordinate) {
        return pieces.get(coordinate);
    }

    public void removePiece(Coordinate coordinate) {
        pieces.remove(coordinate);
    }

    public void movePiece(Coordinate from, Coordinate to) {
        Piece piece = getPiece(from);

        removePiece(from);
        setPieces(to, piece);
    }
    //метод для расстоновки фигур ПЕШОК
    public void setupDefaultPositions() {
        for (File file : File.values()) {
            setPieces(new Coordinate(file, 2), new Pawn(Color.WHITE, new Coordinate(file, 2)));
            setPieces(new Coordinate(file, 7), new Pawn(Color.BLACK, new Coordinate(file, 7)));

        }
        //ладья
        setPieces(new Coordinate(File.A, 1), new Rook(Color.WHITE, new Coordinate(File.A, 1)));
        setPieces(new Coordinate(File.H, 1), new Rook(Color.WHITE, new Coordinate(File.H, 1)));
        setPieces(new Coordinate(File.A, 8), new Rook(Color.BLACK, new Coordinate(File.A, 8)));
        setPieces(new Coordinate(File.H, 8), new Rook(Color.BLACK, new Coordinate(File.H, 8)));

        //кони
        setPieces(new Coordinate(File.B, 1), new Knight(Color.WHITE, new Coordinate(File.B, 1)));
        setPieces(new Coordinate(File.G, 1), new Knight(Color.WHITE, new Coordinate(File.G, 1)));
        setPieces(new Coordinate(File.B, 8), new Knight(Color.BLACK, new Coordinate(File.B, 8)));
        setPieces(new Coordinate(File.G, 8), new Knight(Color.BLACK, new Coordinate(File.G, 8)));

        // слоны
        setPieces(new Coordinate(File.C, 1), new Bishop(Color.WHITE, new Coordinate(File.C, 1)));
        setPieces(new Coordinate(File.F, 1), new Bishop(Color.WHITE, new Coordinate(File.F, 1)));
        setPieces(new Coordinate(File.C, 8), new Bishop(Color.BLACK, new Coordinate(File.C, 8)));
        setPieces(new Coordinate(File.F, 8), new Bishop(Color.BLACK, new Coordinate(File.F, 8)));

        //ферзь
        setPieces(new Coordinate(File.D, 1), new Queen(Color.WHITE, new Coordinate(File.D, 1)));
        setPieces(new Coordinate(File.D, 8), new Queen(Color.BLACK, new Coordinate(File.D, 8)));

        //короли
        setPieces(new Coordinate(File.E, 1), new King(Color.WHITE, new Coordinate(File.E, 8)));
        setPieces(new Coordinate(File.E, 8), new King(Color.BLACK, new Coordinate(File.E, 8)));


    }

    //метод для птого чтоб были и чергвн и белые нечет и чет
    public static boolean isSquareDark(Coordinate coordinate) {
        return (((coordinate.file.ordinal() + 1) + coordinate.rank) % 2) == 0;
    }

    //метод который получает фигуру по координату
    public Piece getPiece(Coordinate coordinate) {
        return pieces.get(coordinate);

    }

    //метод на проверку пустой клетки
    public boolean isSquareEmpty(Coordinate coordinate) {
        return !pieces.containsKey(coordinate);
    }


    private List<Piece> getPieceByColor(Color color) {
        List<Piece> result = new ArrayList<>();

        for (Piece piece : pieces.values()) {
            if (piece.color == color) {
                result.add(piece);
            }
        }
        return result;
    }

    public boolean isSquareAttackByColor(Coordinate coordinate, Color color) {
        List<Piece> pieces = getPieceByColor(color);
        for (Piece piece : pieces) {
            Set<Coordinate> attackedSquares = piece.getAttackedSquares(this);
            //проверка что корректная  ячейка не под боем
            if (attackedSquares.contains(coordinate)) {
                return true;
            }
        }

        return false;
    }
}