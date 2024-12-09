package com.fastcampus.tdd.ch01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordStrengthMeterTest {
    @Test
    void name(){}

    @Test
    void meetsAllCriteriaThenString(){
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("123456789");
        assertEquals(PasswordStrength.STRONG, result);
    }

    @Test
    void meetsOtherCriteriaExpectForLengthThenNormal(){
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("123456");
        assertEquals(PasswordStrength.NORMAL, result);// 3가지 조건을 만족하는 STRONG이 아닌 2가지만 만족하기에 NORMAL
    }
}
