package com.jihwan.section01;

public class PositiveNumberValidator {

    public void checkDividableNumbers(int firstNum, int secondNum) {
        if (secondNum == 0) {
            throw new IllegalArgumentException("0으로 나울 수 없습니다");
        }
    }
}
