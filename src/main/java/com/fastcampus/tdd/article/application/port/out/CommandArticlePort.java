package com.fastcampus.tdd.article.application.port.out;

import com.fastcampus.tdd.article.domain.Article;

public interface CommandArticlePort {
    Article createArticle(Article article);

    Article modifyArticle(Article article);

    void deleteArticle(Long articleId);
}