package com.fastcampus.tdd.ch02;

import org.junit.jupiter.api.*;

public class JunitProcessTest {
    public JunitProcessTest() {
        System.out.println("Constructor");
    }

    @BeforeAll
    static void classAll(){
        System.out.println("Before All");
    }

    @BeforeEach
    void classEach(){
        System.out.println("Before Each");
    }

    @Test
    void testForTest(){
        System.out.println("Test");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After Each");
    }

    @AfterAll
    static void classAllAfterAll() {
        System.out.println("After All");
    }
}
