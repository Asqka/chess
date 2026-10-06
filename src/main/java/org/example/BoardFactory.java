package org.example;

import org.example.pieces.Board.Board;

public class BoardFactory {
    private PieceFactory pieceFactory = new PieceFactory();

    public Board fromFEN(String fen) {
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
