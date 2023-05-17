package com.sopt.instagram.InstagramSERVER.story.service;

import com.sopt.instagram.InstagramSERVER.story.controller.dto.response.StoryInfoDto;
import com.sopt.instagram.InstagramSERVER.story.domain.Story;
import com.sopt.instagram.InstagramSERVER.story.repository.StoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoryService {
    private final StoryRepository storyRepository;

    public List<StoryInfoDto> getStories(Long memberId) {
        List<Story> stories = storyRepository.findByMemberId(memberId);

        return stories.stream()
                .map(story -> StoryInfoDto.of(story)).collect(Collectors.toList());
    }
}
