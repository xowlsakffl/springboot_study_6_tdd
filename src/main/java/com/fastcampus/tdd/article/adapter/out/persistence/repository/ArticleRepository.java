package com.fastcampus.tdd.article.adapter.out.persistence.repository;

import com.fastcampus.tdd.article.adapter.out.persistence.entity.ArticleJpaEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleJpaEntity, Long> {
    List<ArticleJpaEntity> findByBoardId(Long boardId);
}