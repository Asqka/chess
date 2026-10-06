package org.example;

import org.example.pieces.Board.Board;
import org.example.pieces.Board.ConsoleBoard;

public class Main {
    public static void main(String[] args) {
        Board board= new Board();
        board.setupDefaultPositions();

        ConsoleBoard consoleBoard= new ConsoleBoard();
       // consoleBoard.render(board);
//
//        Piece piece  =board.getPiece(new Coordinate(File.G,8));
//        Set<Coordinate> availableMoveSquares = piece.getAvailableMoveSquares(board);
        Game game =new Game(board);
        game.gameLoop();


        }

    }
