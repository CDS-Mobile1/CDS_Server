package com.sopt.instagram.InstagramSERVER.post.controller.dto;

import com.sopt.instagram.InstagramSERVER.friend.domain.Friend;
import com.sopt.instagram.InstagramSERVER.member.domain.Member;
import com.sopt.instagram.InstagramSERVER.post.domain.Post;
import com.sopt.instagram.InstagramSERVER.post.domain.PostImage;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@Getter
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor
public class PostResponseDto {
    private Long memberId;
    private String memberImageUrl;
    private String memberName;
    private Boolean isSpecial;
    private Boolean storyExists;
    private String content;
    List<String> imageUrlList = new ArrayList<>();

    public static PostResponseDto of(Member member, boolean isSpecial, Post post) {
        List<String> result = post.getPostImages().stream()
                .map(PostImage::getImageUrl)
                .collect(Collectors.toList());
        return new PostResponseDto(member.getId(), member.getProfileUrl(), member.getName(),
                isSpecial, member.getStoryExists(),
                post.getContent(), result);
    }
}
