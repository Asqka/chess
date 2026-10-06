package org.example;

import org.example.pieces.Board.Board;
import org.example.pieces.Piece;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    static int countPieces(Board board) {
        int n = 0;
        for (File f : File.values()) {
            for (int r = 1; r <= 8; r++) {
                if (!board.isSquareEmpty(new Coordinate(f, r))) n++;
            }
        }
        return n;
    }

    @Test
    void newBoardIsEmpty() {
        assertEquals(0, countPieces(new Board()));
    }

    @Test
    void defaultSetupHas32Pieces() {
        Board board = new Board();
        board.setupDefaultPositions();
        assertEquals(32, countPieces(board));
    }

    @Test
    void defaultSetupPlacesWhiteBelowAndBlackAbove() {
        Board board = new Board();
        board.setupDefaultPositions();

        assertEquals(Color.WHITE, board.getPiece(new Coordinate(File.E, 2)).color);
        assertEquals(Color.BLACK, board.getPiece(new Coordinate(File.E, 7)).color);
        assertTrue(board.isSquareEmpty(new Coordinate(File.E, 4)));
    }

    @Test
    void movePieceMovesItToNewSquare() {
        Board board = new Board();
        board.setupDefaultPositions();
        Coordinate from = new Coordinate(File.E, 2);
        Coordinate to = new Coordinate(File.E, 4);
        Piece pawn = board.getPiece(from);

        board.movePiece(from, to);

        assertTrue(board.isSquareEmpty(from));
        assertSame(pawn, board.getPiece(to));
    }

    @Test
    void removePieceClearsSquare() {
        Board board = new Board();
        board.setupDefaultPositions();
        Coordinate c = new Coordinate(File.A, 2);

        board.removePiece(c);

        assertTrue(board.isSquareEmpty(c));
    }

    @Test
    void squareColorsAlternate() {
        assertTrue(Board.isSquareDark(new Coordinate(File.A, 1)));
        assertFalse(Board.isSquareDark(new Coordinate(File.B, 1)));
        assertFalse(Board.isSquareDark(new Coordinate(File.A, 2)));
    }
}