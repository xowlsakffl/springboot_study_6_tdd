package com.fastcampus.tdd.ch04.repository;

import java.util.HashMap;
import java.util.Map;

public class StubGradeRepository {
    // 실제론 implements GradeRepository 가 있을것임 그리고 @Override로 모든 메서드들을 오버라이드 하는것
    public Map<String, Integer> findByName(String name) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("OOP", 8);
        map.put("FP", 6);
        map.put("DB", 10);
        return map;
    }
}
