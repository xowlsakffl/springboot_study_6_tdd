package com.fastcampus.tdd.ch01;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String password) {
        if (password.length() < 8) {
            return PasswordStrength.NORMAL;
        }else {
            return PasswordStrength.STRONG;
        }
    }
}
