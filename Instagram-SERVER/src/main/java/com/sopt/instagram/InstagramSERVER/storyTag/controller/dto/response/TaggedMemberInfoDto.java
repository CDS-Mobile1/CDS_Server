package com.sopt.instagram.InstagramSERVER.storyTag.controller.dto.response;

import com.sopt.instagram.InstagramSERVER.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static lombok.AccessLevel.PRIVATE;

@Getter
@AllArgsConstructor(access = PRIVATE)
public class TaggedMemberInfoDto {
    private Long memberId;
    private String memberImageUrl;
    private String memberName;

    public static TaggedMemberInfoDto of(Member member) {
        return new TaggedMemberInfoDto(member.getId(), member.getProfileUrl(), member.getName());
    }
}
