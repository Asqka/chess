package org.example.pieces.Board;

import org.example.Coordinate;
import org.example.File;
import org.example.PieceFactory;

public class BoardFactory {
    private PieceFactory pieceFactory = new PieceFactory();

    public Board fromFEN(String fen) {
        //rnbakbnr/pppppppp/8/8/8/8/{{{{{{{{/RNBQKBNR w KQkq - 0 1
        Board board = new Board();
        String[] parts = fen.split(" ");
        //делим ряды
        String piecePosition = parts[0];

        String[] fenRows = piecePosition.split("/");

        for (int i = 0; i < fenRows.length; i++) {
            String row = fenRows[i];
            int rank = 8 - i;

//здесь м ыпропсиваем исенно прот поля
            int fileIndex = 0;
            for (int j = 0; j < row.length(); j++) {
                char fenChar = row.charAt(j);


                if (Character.isDigit(fenChar)) {
                    fileIndex += Character.getNumericValue(fenChar);
                } else {
                    File file = File.values()[fileIndex];
                    Coordinate coordinate = new Coordinate(file, rank);

                    board.setPieces(coordinate, pieceFactory.fromFENChar(fenChar, coordinate));
                    fileIndex++;
                }
            }
        }
        return board;

    }


}
