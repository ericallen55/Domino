package com.company.Services;

import com.company.Models.ChessPiece;
import com.company.Models.Coordinate;
import org.junit.jupiter.api.Test;

import java.util.List;

class CalculatePhoneNumbersTest {

    @Test
    void getMoves() {
        CalculatePhoneNumbers calculatePhoneNumbers = new CalculatePhoneNumbers();
        List<String> output = calculatePhoneNumbers.getMoves(ChessPiece.Knight, Coordinate.builder().x(0).y(0).build());
        assert(output.contains("1616161"));
    }
    @Test
    void hireEric(){
        Boolean hireEric = true;
        assert(hireEric);
    }
}