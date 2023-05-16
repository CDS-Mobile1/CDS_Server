package com.sopt.instagram.InstagramSERVER.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorStatus {

    /*
    BAD_REQUEST
     */
    VALIDATION_EXCEPTION(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),

    /*
    SERVER_ERROR
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "예상치 못한 서버 에러가 발생했습니다."),

    /*
    NOT_FOUND
     */
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 멤버가 존재하지 않습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
