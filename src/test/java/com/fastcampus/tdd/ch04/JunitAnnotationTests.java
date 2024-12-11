package com.fastcampus.tdd.ch04;

import com.fastcampus.tdd.ch04.domain.dto.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class JunitAnnotationTests {
    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    @NullAndEmptySource
    void userNameValidatorTests(String userName){
        System.out.println("username =>" + userName);
        assertThatThrownBy(() -> new User(userName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("User의 이름이 Null이면 예외가 발생")
    public void givenUserName_whenNull_thenException(){
        assertThatThrownBy(() -> new User(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("User의 이름이 공백이면 예외가 발생")
    public void givenUserName_whenBlank_thenException(){
        assertThatThrownBy(() -> new User(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2", "2, 4",  "3, 6", "4, 8"})
    void csvSourceExampleTest(int input, int expected){
        assertEquals(expected, input * 2);
    }

    @RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME)
    void repeatedTest(RepetitionInfo repetitionInfo){
        int currentRepetition = repetitionInfo.getCurrentRepetition();
        System.out.println("currentRepetition = " + currentRepetition + "\t" + repetitionInfo.getTotalRepetitions());
    }

    @TestFactory
    List<DynamicNode> testFactoryTest(){
        int size = 10;
        // DB에서 가져오거나
        // 외부 API에서 가져오거나
        List<DynamicNode> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int finalI = i;
            result.add(dynamicTest("Test CaseName"+ i, () -> System.out.println("Dynamic Test #" + finalI)));
        }
        return result;
    }
}
