package com.company.Services;

import com.company.Models.ChessPiece;
import com.company.Models.Coordinate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CalculatePhoneNumbers {
    public List<String> getMoves(ChessPiece chessPiece, Coordinate coordinate) {
        Integer length = 7;
        List<String> strings = new ArrayList<>();
        StringBuilder parent = mapCoordinateToNumber(coordinate);
        return getNextMove(chessPiece, coordinate, length, strings, parent);
    }

    private List<String> getNextMove(ChessPiece chessPiece, Coordinate startingCoordinate, Integer length, List<String> previousNumbers, StringBuilder parent) {
        Integer tempLength = --length;
        if (length > 0) {
            List<Coordinate> coordinates = validMoves(chessPiece, startingCoordinate);
            coordinates.forEach(coordinate -> {
                StringBuilder tempString = new StringBuilder(parent + Objects.requireNonNull(mapCoordinateToNumber(coordinate)).toString());
                getNextMove(chessPiece, coordinate, tempLength, previousNumbers, tempString);
            });
        }
        if(parent.length() == 7)
            previousNumbers.add(parent.toString());
        return previousNumbers;
    }

    private StringBuilder mapCoordinateToNumber(Coordinate coordinate) {
        switch (coordinate.getX()) {
            case 0 -> {
                switch (coordinate.getY()) {
                    case 0:
                        return new StringBuilder("1");
                    case 1:
                        return new StringBuilder("4");
                    case 2:
                        return new StringBuilder("7");
                }
            }
            case 1 -> {
                switch (coordinate.getY()) {
                    case 0:
                        return new StringBuilder("2");
                    case 1:
                        return new StringBuilder("5");
                    case 2:
                        return new StringBuilder("8");
                    case 3:
                        return new StringBuilder("0");
                }
            }
            case 2 -> {
                switch (coordinate.getY()) {
                    case 0:
                        return new StringBuilder("3");
                    case 1:
                        return new StringBuilder("6");
                    case 2:
                        return new StringBuilder("9");
                }
            }
        }
        return null;
    }

    private List<Coordinate> chessPieceRules(ChessPiece chessPiece) {
        //Hard coding one to keep it simple
        //knight 2 one way 1 the other
        List<Coordinate> possibleCoordinates = new ArrayList<>();
        switch (chessPiece) {
            case Knight -> {
                possibleCoordinates.add(Coordinate.builder().x(-1).y(-2).build());
                possibleCoordinates.add(Coordinate.builder().x(-1).y(2).build());
                possibleCoordinates.add(Coordinate.builder().x(-2).y(-1).build());
                possibleCoordinates.add(Coordinate.builder().x(-2).y(1).build());
                possibleCoordinates.add(Coordinate.builder().x(1).y(-2).build());
                possibleCoordinates.add(Coordinate.builder().x(1).y(2).build());
                possibleCoordinates.add(Coordinate.builder().x(2).y(-1).build());
                possibleCoordinates.add(Coordinate.builder().x(2).y(1).build());
            }
            default -> {//left as an exercise for the reader"
                 }
        }

        return possibleCoordinates;
    }

    private List<Coordinate> validMoves(ChessPiece chessPiece, Coordinate startingCoordinate) {
        List<Coordinate> moves = new ArrayList<>();
        List<Coordinate> possibleCoordinates = chessPieceRules(chessPiece);
        possibleCoordinates.forEach(coordinate -> {
            Coordinate move = Coordinate.builder()
                    .x(startingCoordinate.getX() + coordinate.getX())
                    .y(startingCoordinate.getY() + coordinate.getY())
                    .build();
            boolean badMove = (move.getX() < 0 || move.getY() < 0 || move.getX() > 2 || move.getY() > 3 ||
                    (move.getY() == 3 && (move.getX() == 0 || move.getX() == 2)));
            if (!badMove)
                moves.add(move);
        });
        return moves;
    }
}
