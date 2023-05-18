package com.sopt.instagram.InstagramSERVER.storyTag.service;

import com.sopt.instagram.InstagramSERVER.member.domain.Member;
import com.sopt.instagram.InstagramSERVER.storyTag.controller.dto.response.TaggedMemberInfoDto;
import com.sopt.instagram.InstagramSERVER.storyTag.repository.StoryTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoryTagService {
    private final StoryTagRepository storyTagRepository;

    public List<TaggedMemberInfoDto> getTaggedMember(Long storyId) {
        List<Member> taggedMembers = storyTagRepository.findTaggedMembersByStoryId(storyId);

        return taggedMembers.stream().map(member -> TaggedMemberInfoDto.of(member)).collect(Collectors.toList());
    }
}
