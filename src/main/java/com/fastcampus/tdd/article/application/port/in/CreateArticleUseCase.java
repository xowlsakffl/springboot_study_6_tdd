package com.fastcampus.tdd.article.application.port.in;

import com.fastcampus.tdd.article.adapter.in.api.dto.ArticleDto;
import com.fastcampus.tdd.article.domain.Article;

public interface CreateArticleUseCase {
    Article createArticle(ArticleDto.CreateArticleRequest request);
}