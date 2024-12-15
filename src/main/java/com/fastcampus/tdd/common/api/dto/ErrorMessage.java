package com.fastcampus.tdd.common.api.dto;

import java.time.LocalDateTime;

public record ErrorMessage(
        Integer statusCode,
        String message,
        LocalDateTime timestamp
) {}