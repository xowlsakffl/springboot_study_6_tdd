package com.fastcampus.tdd.ch04.domain.dto.test_doubles;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private int averageGrade;
    private Map<String, Integer> grades;
    private char sex;
    private String phoneNumber;
}
