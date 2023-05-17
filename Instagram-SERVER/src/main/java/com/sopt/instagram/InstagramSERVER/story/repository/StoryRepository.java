package com.sopt.instagram.InstagramSERVER.story.repository;

import com.sopt.instagram.InstagramSERVER.story.domain.Story;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface StoryRepository extends Repository<Story, Long> {

    void save(Story story);

    Optional<Story> findById(Long storyId);

    List<Story> findByMemberId(Long memberId);
}
