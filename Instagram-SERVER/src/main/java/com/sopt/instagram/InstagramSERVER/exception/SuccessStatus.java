package com.sopt.instagram.InstagramSERVER.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessStatus {

    /*
    post
     */
    POST_CREATE_SUCCESS(HttpStatus.CREATED, "게시물 생성 완료"),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
