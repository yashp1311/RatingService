package com.example.ratingservice.exception;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Getter
public class RatingException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RatingException(String message, Throwable cause) {
        super(message, cause);
    }

    public RatingException(String message) {
        super(message);
    }

    public RatingException(Throwable cause) {
        super(cause);
    }
}