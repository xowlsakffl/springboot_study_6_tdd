package com.fastcampus.tdd.article.application.service;

import com.fastcampus.tdd.article.adapter.in.api.dto.ArticleDto;
import com.fastcampus.tdd.article.application.port.in.CreateArticleUseCase;
import com.fastcampus.tdd.article.application.port.in.DeleteArticleUseCase;
import com.fastcampus.tdd.article.application.port.in.GetArticleUseCase;
import com.fastcampus.tdd.article.application.port.in.ModifyArticleUseCase;
import com.fastcampus.tdd.article.application.port.out.CommandArticlePort;
import com.fastcampus.tdd.article.application.port.out.LoadArticlePort;
import com.fastcampus.tdd.article.application.port.out.LoadBoardPort;
import com.fastcampus.tdd.article.domain.Article;
import com.fastcampus.tdd.common.exception.AccessDeniedException;
import com.fastcampus.tdd.common.exception.ResourceNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@Transactional
public class ArticleService implements GetArticleUseCase, CreateArticleUseCase, ModifyArticleUseCase, DeleteArticleUseCase {
    private final LoadArticlePort loadArticlePort;
    private final CommandArticlePort commandArticlePort;
    private final LoadBoardPort loadBoardPort;

    public ArticleService(LoadArticlePort loadArticlePort, CommandArticlePort commandArticlePort, LoadBoardPort loadBoardPort) {
        this.loadArticlePort = loadArticlePort;
        this.commandArticlePort = commandArticlePort;
        this.loadBoardPort = loadBoardPort;
    }

    @Override
    @Transactional(readOnly = true)
    public Article getArticleById(Long articleId) {
        return loadArticlePort.findArticleById(articleId)
                .orElseThrow(() -> new ResourceNotFoundException("id : " + articleId + " 게시물이 없습니다"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Article> getArticlesByBoard(Long boardId) {
        return loadArticlePort.findArticlesByBoardId(boardId);
    }

    @Override
    public Article createArticle(ArticleDto.CreateArticleRequest request) {
        Assert.hasLength(request.subject(), "subject should not empty");
        Assert.hasLength(request.content(), "content should not empty");
        Assert.hasLength(request.username(), "username should not empty");

        var board = loadBoardPort.findBoardById(request.boardId())
                .orElseThrow();
        var article = Article.builder()
                .board(board)
                .subject(request.subject())
                .content(request.content())
                .username(request.username())
                .createdAt(LocalDateTime.now())
                .build();

        return commandArticlePort.createArticle(article);
    }

    @Override
    public Article modifyArticle(ArticleDto.UpdateArticleRequest request) {
        Article article = loadArticlePort.findArticleById(request.id())
                .orElseThrow();

        if (!article.getUsername().equals(request.username())) {
            throw new AccessDeniedException("");
        }

        article.update(request.subject(), request.content());
        return commandArticlePort.modifyArticle(article);
    }

    @Override
    public void deleteArticle(Long articleId) {
        commandArticlePort.deleteArticle(articleId);
    }
}