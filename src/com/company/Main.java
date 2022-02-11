package com.company;

import com.company.Models.ChessPiece;
import com.company.Models.Coordinate;
import com.company.Services.CalculatePhoneNumbers;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        CalculatePhoneNumbers calculatePhoneNumbers = new CalculatePhoneNumbers();
        List<String> output = calculatePhoneNumbers.getMoves(ChessPiece.Knight, Coordinate.builder().x(0).y(0).build());
    }
}
/*
   0 1 2
# |1|2|3|0
# |4|5|6|1
# |7|8|9|2
# |*|0|#|3
#
# Problem:
# Given a chess piece and a starting position
# Making only legal chess moves find all valid 7 digit phone numbers
#
# Example: Knight starts at 1
# Some possible prefixes: 167, 183, 161, etc.
//vaild data
//vaild it not *, #
//List<PhoneNumber> getNumber(enum chestPiece, int x,int y)
//king ,1, 1
//array of valid moves eq, pawn forward 1, or on first move forward 2 or attach diangle 1

//assumptions
    //board is staic
    //static (0,0) = 1
    //(3,2) = #  //validiate this
    //no number can start with 0
//first digit x,y ex. 5
//List<Strings> recursion, ex. 2, 4, 6, 8(position)(length)(piece)(previous number)

//cornercase can't move outside of table, ex. 0 king, can't move right/left or down

//write lots of unit tests

//assert not # or *
//length 7
//queen, 5 verify returns contains 5454545
assert(List<Intgers>.contains(5454545));
//bishop
//knight

//assert one of the 7 digits numbers returns
//static definition of moves
//king x, y, doesn't work for diagonal
//ex. king, 1, 1;
//ex. bishop
//ex. knight
List<Interger> getNumber(enum chestPiece, int value){
    Interger length = 6;
    return recursive(chestPiece, validMove(chestPice, x, y), length--))
}

List<Interger> recursive(enum chestPiece, currentPostion length){
    if(length > 0)
        recursive(chestPiece, validMove(chestPice, currentPostion), length--));
        else
        return //phonenumber+ currentPostion
}

validMove(enum chestPiece, currentPostion){
    switch: chestPiece
    case: king{
        List<> moves;
        moves.add(validLocation(currentPosition(x++, y)))
    }
}
 */