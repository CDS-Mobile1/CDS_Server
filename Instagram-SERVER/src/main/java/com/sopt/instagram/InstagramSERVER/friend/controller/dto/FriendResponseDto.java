package com.sopt.instagram.InstagramSERVER.friend.controller.dto;

import com.sopt.instagram.InstagramSERVER.friend.domain.Friend;
import com.sopt.instagram.InstagramSERVER.member.domain.Member;
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

    public static FriendResponseDto of(Member member, Friend friend) {
        return new FriendResponseDto(member.getId(), member.getProfileUrl(), member.getName(), friend.getIsSpecial());
    }
}
