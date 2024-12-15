package com.fastcampus.tdd.article.domain;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Ch02Clip01JunitAssertJTests {
    private Board board;

    @BeforeEach
    void setUp(){
        board = new Board(1L, "board");
    }

    @Test
    @DisplayName("수정 테스트")
    void updateArticle(){
        var article = Article.builder()
                .id(1L)
                .board(board)
                .subject("subject")
                .content("content")
                .username("user")
                .createdAt(LocalDateTime.now())
                .build();

        article.update("new subject", "new content");

        assertThat(article.getId())
                .isEqualTo(1L);

        assertThat(article)
                .hasNoNullFieldsOrProperties()// null인 필드가 없다
                .hasFieldOrPropertyWithValue("id", 1L)
                .hasFieldOrPropertyWithValue("board.id", 1L)
                .hasFieldOrPropertyWithValue("subject", "new subject")
                .hasFieldOrPropertyWithValue("content", "new content")
                .hasFieldOrPropertyWithValue("username", "user")
                .hasFieldOrProperty("createdAt");
    }

    @Test
    @DisplayName("BDD 스타일 수정테스트")
    void updateArticle_BDDStyle(){
        var article = Article.builder()
                .id(1L)
                .board(board)
                .subject("subject")
                .content("content")
                .username("user")
                .createdAt(LocalDateTime.now())
                .build();

        article.update("new subject", "new content");

        BDDAssertions.then(article)
                .hasNoNullFieldsOrProperties()// null인 필드가 없다
                .hasFieldOrPropertyWithValue("id", 1L)
                .hasFieldOrPropertyWithValue("board.id", 1L)
                .hasFieldOrPropertyWithValue("subject", "new subject")
                .hasFieldOrPropertyWithValue("content", "new content")
                .hasFieldOrPropertyWithValue("username", "user");
    }
}
