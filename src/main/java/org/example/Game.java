package org.example;

import org.example.pieces.Board.Board;
import org.example.pieces.Board.ConsoleBoard;
import org.example.pieces.InputCoordinate;
import org.example.pieces.Piece;

import java.util.Set;

public class Game {

    private final Board board;
    private ConsoleBoard renderer=new ConsoleBoard();
    private Coordinate targetCoordinate;

    public Game(Board board) {
        this.board = board;
    }
    public void gameLoop() {
        boolean isWhiteMove = true;

        while (true) {
            clearConsole();
            renderer.render(board);

            System.out.println(isWhiteMove ? "ход белых" : "ход черных");

            Coordinate sourceCoordinate =
                    InputCoordinate.inputPieceCoordinateForColor(
                            isWhiteMove ? Color.WHITE : Color.BLACK, board);

            Piece piece = board.getPiece(sourceCoordinate);
            Set<Coordinate> availableMoveSquares =
                    piece.getAvailableMoveSquares(board);
            renderer.render(board,piece);


            Coordinate targetCoordinate =
                    InputCoordinate.inputAvailableSquare(availableMoveSquares);

            board.movePiece(sourceCoordinate, targetCoordinate);

            isWhiteMove = !isWhiteMove;
        }
    }
    private void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
