package com.fastcampus.tdd.article.domain;

import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class Ch02Clip01JunitTests {
    @BeforeAll
    static void initAll(){
        System.out.println("Before All");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("After All");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Before Each");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After Each");
    }

    @Test
    @DisplayName("Article 생성 테스트")
    void constructArticle() {
        var board = new Board(1L, "board");

        var article = Article.builder()
                .id(1L)
                .board(board)
                .subject("subject")
                .content("content")
                .username("user")
                .createdAt(LocalDateTime.now())
                .build();

        assertEquals(1L, article.getId());
        assertEquals(article.getBoard(), board);
        assertEquals("subject", article.getSubject());
        assertEquals("content", article.getContent());
        assertNotEquals("subject2", article.getSubject());
        assertNotNull(article.getCreatedAt());

        System.out.println("succeeding test");
    }


    @Test
    @DisplayName("실패 테스트")
    void failTestExample() {
        assertEquals(3, 1+1, "테스트 실패시 메시지");
        System.out.println("failing test");
    }
}
