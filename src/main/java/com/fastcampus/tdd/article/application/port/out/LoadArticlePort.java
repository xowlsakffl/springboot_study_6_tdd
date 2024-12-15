package com.fastcampus.tdd.article.application.port.out;

import com.fastcampus.tdd.article.domain.Article;
import java.util.List;
import java.util.Optional;

public interface LoadArticlePort {
    Optional<Article> findArticleById(Long articleId);
    List<Article> findArticlesByBoardId(Long boardId);
}