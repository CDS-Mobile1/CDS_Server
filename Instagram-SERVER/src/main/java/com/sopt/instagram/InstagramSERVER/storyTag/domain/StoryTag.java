package com.sopt.instagram.InstagramSERVER.storyTag.domain;

import com.sopt.instagram.InstagramSERVER.common.domain.TimeStamped;
import com.sopt.instagram.InstagramSERVER.member.domain.Member;
import com.sopt.instagram.InstagramSERVER.story.domain.Story;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class StoryTag extends TimeStamped {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "storytag_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "story_id")
    private Story story;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "tagged_member_id")
    private Member member;

    @Builder
    public StoryTag(Story story, Member member) {
        this.story = story;
        this.member = member;
    }
}
