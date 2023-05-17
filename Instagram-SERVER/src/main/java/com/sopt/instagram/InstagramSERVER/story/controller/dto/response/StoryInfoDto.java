package com.sopt.instagram.InstagramSERVER.story.controller.dto.response;

import com.sopt.instagram.InstagramSERVER.story.domain.Story;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static lombok.AccessLevel.PRIVATE;

@Getter
@AllArgsConstructor(access = PRIVATE)
public class StoryInfoDto {
    private Long storyId;
    private String storyImageUrl;

    public static StoryInfoDto of(Story story) {
        return new StoryInfoDto(story.getId(), story.getImageUrl());
    }
}
