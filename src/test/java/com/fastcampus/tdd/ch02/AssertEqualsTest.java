package com.fastcampus.tdd.ch02;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class AssertEqualsTest {
    @Test
    void assertEqualsExampleTest() {
        int actual = 1;
        int expected = 1;
        assertEquals(expected, actual);
    }

    private String toUpperCase(String name) throws NullPointerException{
        if(name == null) throw new NullPointerException();
        return name.toUpperCase();
    }

    @Test
    public void givenNothing_whenToUpperCase_thenThrowNullPointerExceptionTrue() throws Exception{
        // 예외가 NullPointerException인지 확인한다 맞다면 true 아니라면 false
        assertThrows(NullPointerException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                toUpperCase(null);
            }
        });
    }

    @Test
    public void givenNothing_whenToUpperCase_thenThrowNullPointerException() throws Exception{
        // 전체적인 흐름에 대한 메서드처리가 fail
        try{
            String name = toUpperCase(null);
            fail();
            assertEquals("AMS", name);
        }catch(NullPointerException e){

        }
    }
}
