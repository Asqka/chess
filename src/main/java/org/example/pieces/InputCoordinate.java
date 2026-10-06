package org.example.pieces;

import org.example.*;
import org.example.pieces.Board.Board;

import java.util.Scanner;
import java.util.Set;

public class InputCoordinate {
    private  static   final   Scanner scanner =new Scanner(System.in);


    public static Coordinate input(){
        System.out.println("введите координаты  фигуры для перемещения ");
        while (true){
            System.out.println("введите корректные координаты (ex. a1");

            String line =scanner.nextLine();

            if(line.length() !=2){
                System.out.println("неправильный формат ввода");
                continue;
            }
            char fileChar=line.charAt(0);
            char rankChar=line.charAt(1);

            if(!Character.isLetter(fileChar)){
                System.out.println("неправильнл введен формат буквы ");
                continue;

            }
           if(! Character.isDigit(rankChar)){
               System.out.println("неправильно введен формат цифры ");
               continue;

           }
           int rank=Character.getNumericValue(rankChar);
           if(rank<1||rank>8){
               System.out.println("invalid format");
               continue;

           }

             File file =File.fromChar(fileChar);
           if(file==null){
               System.out.println("invalid Format");
               continue;
           }
           return  new Coordinate(file,rank);
        }
    }
    public static Coordinate inputPieceCoordinateForColor(Color color, Board board){
        while (true){
            Coordinate coordinate= input();
            if (board.isSquareEmpty(coordinate)) {
                System.out.println("пустая клетка");
                continue;
            }

            Piece piece = board.getPiece(coordinate);

            if (piece.color != color) {
                System.out.println("wrong color");
                continue;
            }


            Set<Coordinate>availableMoveSquares= piece.getAvailableMoveSquares(board);
            if(availableMoveSquares.size()==0){
                System.out.println("blocked piece");
                continue;
            }
            return coordinate;


        }
    }
    public  static  Coordinate inputAvailableSquare(Set<Coordinate> coordinates){
        while (true){
            Coordinate input=input();


            if(!coordinates.contains(input)){
                System.out.println("не досупное поле для хода");
                continue;
            }
            return input;
        }
    }
    public static void main(String[] args) {
        // Создаём доску и расставляем фигуры
        Board board = new Board();
        board.setupDefaultPositions();

        // Выбираем фигуру белого цвета с проверками
        Coordinate coordinate = InputCoordinate.inputPieceCoordinateForColor(Color.WHITE, board);

        // Можно вывести выбранную координату
        System.out.println("Вы выбрали фигуру на: " + coordinate.file + coordinate.rank);
    }

}
