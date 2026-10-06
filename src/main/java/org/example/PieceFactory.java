package org.example;

import org.example.pieces.*;

public class PieceFactory {
    Piece fromFENChar(char fenChar, Coordinate coordinate) {
        switch (fenChar) {
            case 'p':
                return new Pawn(Color.BLACK, coordinate);
            case 'P':
                return new Pawn(Color.WHITE, coordinate);
            case 'r':
                return new Rook(Color.BLACK, coordinate);
            case 'R':
                return new Rook(Color.WHITE, coordinate);
            case 'n':
                return new Knight(Color.BLACK, coordinate);
            case 'N':
                return new Knight(Color.WHITE, coordinate);
            case 'b':
                return new Bishop(Color.BLACK, coordinate);
            case 'B':
                return new Bishop(Color.WHITE, coordinate);
            case 'q':
                return new Queen(Color.BLACK, coordinate);
            case 'Q':
                return new Queen(Color.WHITE, coordinate);
            case 'k':
                return new King(Color.BLACK, coordinate);
            case 'K':
                return new King(Color.WHITE, coordinate);
            default:
                throw new RuntimeException("неизвестная буква");

        }
    }
}
