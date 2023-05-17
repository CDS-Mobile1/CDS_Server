package com.sopt.instagram.InstagramSERVER.storyTag.repository;

import com.sopt.instagram.InstagramSERVER.member.domain.Member;
import com.sopt.instagram.InstagramSERVER.storyTag.domain.StoryTag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StoryTagRepository extends Repository<StoryTag, Long> {

    @Query("select m from Member m join StoryTag st on m.id = st.member.id where st.story.id = :storyId")
    List<Member> findTaggedMembersByStoryId(@Param("storyId") Long storyId);
}
