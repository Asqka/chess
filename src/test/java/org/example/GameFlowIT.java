package org.example;

import org.example.pieces.Board.Board;
import org.example.pieces.Piece;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GameFlowIT {

    private static final String START_FEN =
            "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";

    private static Coordinate c(File f, int r) {
        return new Coordinate(f, r);
    }

    @Test
    void whitePawnOnStartCanMoveOneOrTwoSquares() {
        Board board = new BoardFactory().fromFEN(START_FEN);
        Piece pawn = board.getPiece(c(File.E, 2));

        Set<Coordinate> moves = pawn.getAvailableMoveSquares(board);

        assertEquals(Set.of(c(File.E, 3), c(File.E, 4)), moves);
    }

    @Test
    void knightOnStartHasTwoMoves() {
        Board board = new BoardFactory().fromFEN(START_FEN);
        Piece knight = board.getPiece(c(File.B, 1));

        Set<Coordinate> moves = knight.getAvailableMoveSquares(board);

        assertEquals(Set.of(c(File.A, 3), c(File.C, 3)), moves);
    }

    @Test
    void shortOpeningSequenceUpdatesBoard() {
        Board board = new BoardFactory().fromFEN(START_FEN);

        board.movePiece(c(File.E, 2), c(File.E, 4));
        board.movePiece(c(File.E, 7), c(File.E, 5));
        board.movePiece(c(File.G, 1), c(File.F, 3));

        assertTrue(board.isSquareEmpty(c(File.E, 2)));
        assertTrue(board.isSquareEmpty(c(File.G, 1)));
        assertEquals(Color.WHITE, board.getPiece(c(File.E, 4)).color);
        assertEquals(Color.BLACK, board.getPiece(c(File.E, 5)).color);
        assertEquals(Color.WHITE, board.getPiece(c(File.F, 3)).color);
        assertEquals(32, BoardTest.countPieces(board));
    }

    @Test
    void pawnsAttackSquaresInFrontOfThem() {
        Board board = new BoardFactory().fromFEN(START_FEN);

        assertTrue(board.isSquareAttackByColor(c(File.E, 3), Color.WHITE));
        assertFalse(board.isSquareAttackByColor(c(File.E, 5), Color.WHITE));
    }
}