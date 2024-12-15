package com.fastcampus.tdd.article.adapter.out.persistence;

import com.fastcampus.tdd.article.adapter.out.persistence.entity.BoardJpaEntity;
import com.fastcampus.tdd.article.adapter.out.persistence.repository.BoardRepository;
import com.fastcampus.tdd.article.application.port.out.LoadBoardPort;
import com.fastcampus.tdd.article.domain.Board;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class BoardPersistenceAdapter implements LoadBoardPort {
    private final BoardRepository boardRepository;

    public BoardPersistenceAdapter(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Optional<Board> findBoardById(Long boardId) {
        return boardRepository.findById(boardId)
                .map(BoardJpaEntity::toDomain);
    }
}