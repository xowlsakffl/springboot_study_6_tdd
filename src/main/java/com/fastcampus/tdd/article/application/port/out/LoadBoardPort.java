package com.fastcampus.tdd.article.application.port.out;

import com.fastcampus.tdd.article.domain.Board;
import java.util.Optional;

public interface LoadBoardPort {
    Optional<Board> findBoardById(Long boardId);
}