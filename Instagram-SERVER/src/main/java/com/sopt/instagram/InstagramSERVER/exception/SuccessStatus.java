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

    /*
    story
     */
    STORY_INQUIRY_SUCCESS(HttpStatus.OK, "해당 멤버 스토리 조회 완료"),

    /*
    story_tag
     */
    STORY_TAGGED_MEMBER_INQUIRY_SUCCESS(HttpStatus.OK, "해당 스토리에 태그된 멤버 조회완료"),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
