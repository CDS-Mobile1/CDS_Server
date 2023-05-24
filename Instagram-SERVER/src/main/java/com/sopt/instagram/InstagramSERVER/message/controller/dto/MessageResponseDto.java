package com.sopt.instagram.InstagramSERVER.message.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@Getter
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
public class MessageResponseDto {
    private Long memberId;
    private String memberImageUrl;
    private String memberName;
    private String latestMessage;
    private boolean isSpecial;
    private boolean isFavorite;
    private boolean storyExists;

    public static MessageResponseDto of(Long memberId, String memberImageUrl, String memberName, String latestMessage, boolean isSpecial, boolean isFavorite, boolean storyExists) {
        return new MessageResponseDto(memberId, memberImageUrl, memberName, latestMessage, isSpecial, isFavorite, storyExists);
    }
}
