package com.sopt.instagram.InstagramSERVER.story.controller;

import com.sopt.instagram.InstagramSERVER.common.dto.ApiResponseDto;
import com.sopt.instagram.InstagramSERVER.story.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static com.sopt.instagram.InstagramSERVER.common.exception.SuccessStatus.STORY_INQUIRY_SUCCESS;

@RestController
@RequiredArgsConstructor
public class StoryController {
    private final StoryService storyService;

    @GetMapping("/api/story/{memberId}")
    public ApiResponseDto getStories(@PathVariable final Long memberId) {
        return ApiResponseDto.success(STORY_INQUIRY_SUCCESS, storyService.getStories(memberId));
    }
}
