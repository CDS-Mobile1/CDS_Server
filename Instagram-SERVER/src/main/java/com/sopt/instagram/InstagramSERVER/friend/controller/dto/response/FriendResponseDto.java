package com.sopt.instagram.InstagramSERVER.friend.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.*;

@Getter
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor
public class FriendResponseDto {

    private Long memberId;
    private String memberImageUrl;
    private String memberName;
    private Boolean isSpecial;

    public static FriendResponseDto of(Long memberId, String memberImageUrl, String memberName, boolean isSpecial) {
        return new FriendResponseDto(memberId, memberImageUrl, memberName, isSpecial);
    }
}
