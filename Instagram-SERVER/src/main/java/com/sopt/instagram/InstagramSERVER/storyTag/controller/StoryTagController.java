package com.sopt.instagram.InstagramSERVER.storyTag.controller;

import com.sopt.instagram.InstagramSERVER.common.dto.ApiResponseDto;
import com.sopt.instagram.InstagramSERVER.storyTag.service.StoryTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static com.sopt.instagram.InstagramSERVER.exception.SuccessStatus.STORY_TAGGED_MEMBER_INQUIRY_SUCCESS;

@RestController
@RequiredArgsConstructor
public class StoryTagController {
    private final StoryTagService storyTagService;

    @GetMapping("api/story/{storyId}/tag")
    public ApiResponseDto getTaggedMember(@PathVariable final Long storyId) {
        return ApiResponseDto.success(STORY_TAGGED_MEMBER_INQUIRY_SUCCESS, storyTagService.getTaggedMember(storyId));
    }
}
