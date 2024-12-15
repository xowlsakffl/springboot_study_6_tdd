package com.fastcampus.tdd.article.adapter.out.persistence.repository;

import com.fastcampus.tdd.article.adapter.out.persistence.entity.BoardJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardJpaEntity, Long> {
}