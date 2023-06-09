package com.sopt.instagram.InstagramSERVER.common.exception;

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
    READ_POST_BY_MEMBER_SUCCESS(HttpStatus.OK, "게시물 조회 성공"),

    /*
    story
     */
    STORY_INQUIRY_SUCCESS(HttpStatus.OK, "해당 멤버 스토리 조회 완료"),

    /*
    story_tag
     */
    STORY_TAGGED_MEMBER_INQUIRY_SUCCESS(HttpStatus.OK, "해당 스토리에 태그된 멤버 조회완료"),
    
    /*
    friend
     */
    READ_ALL_FRIEND_STORY_SUCCESS(HttpStatus.OK, "팔로우한 친구들 스토리 목록 조회 성공"),
    READ_FAVORITES_FRIEND_STORY_SUCCESS(HttpStatus.OK, "즐겨찾기한 친구들 스토리 목록 조회 성공"),
    UPDATE_FAVORITES_STATUS_SUCCESS(HttpStatus.OK, "즐겨찾기 변경 성공"),

    /*
    dm
     */
    READ_ALL_MESSAGE_SUCCESS(HttpStatus.OK, "DM 조회 성공"),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
