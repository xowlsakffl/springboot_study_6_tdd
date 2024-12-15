package com.fastcampus.tdd.article.application.port.in;

import com.fastcampus.tdd.article.domain.Article;
import java.util.List;

public interface GetArticleUseCase {
    Article getArticleById(Long articleId);

    List<Article> getArticlesByBoard(Long boardId);
}