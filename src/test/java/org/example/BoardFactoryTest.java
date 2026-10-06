package org.example;

import org.example.pieces.Board.Board;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardFactoryTest {

    private static final String START_FEN =
            "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";

    @Test
    void emptyFenGivesEmptyBoard() {
        Board board = new BoardFactory().fromFEN("8/8/8/8/8/8/8/8 w - - 0 1");
        assertEquals(0, BoardTest.countPieces(board));
    }

    @Test
    void startFenGives32Pieces() {
        Board board = new BoardFactory().fromFEN(START_FEN);
        assertEquals(32, BoardTest.countPieces(board));
    }

    @Test
    void startFenPlacesColorsCorrectly() {
        Board board = new BoardFactory().fromFEN(START_FEN);
        assertEquals(Color.WHITE, board.getPiece(new Coordinate(File.A, 1)).color);
        assertEquals(Color.BLACK, board.getPiece(new Coordinate(File.A, 8)).color);
    }
}