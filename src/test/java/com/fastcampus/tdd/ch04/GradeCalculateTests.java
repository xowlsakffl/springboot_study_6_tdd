package com.fastcampus.tdd.ch04;

import com.fastcampus.tdd.ch04.domain.dto.test_doubles.Student;
import com.fastcampus.tdd.ch04.repository.StubGradeRepository;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GradeCalculateTests {
    private StubGradeRepository stubGradeRepository;

    public GradeCalculateTests() {
        stubGradeRepository = new StubGradeRepository();
    }

    private Map<String, Integer> grades(Student student){
        return stubGradeRepository.findByName(student.getName());
    };

    @Test
    void averageGradesTests(){
         Student student = new Student("an", 0, new HashMap<>(), 'M', "01012341234");
         Map<String, Integer> result = grades(student);

         int total = 0;
         int expected = 8;
         for(String grade: result.keySet()){
             total += result.get(grade);
         }

         assertEquals(expected, total/result.size());
    }
}
