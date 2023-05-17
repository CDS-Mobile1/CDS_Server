package com.sopt.instagram.InstagramSERVER.story.domain;

import com.sopt.instagram.InstagramSERVER.member.domain.Member;
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
public class Story {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "story_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Builder
    public Story(Member member, String imageUrl) {
        this.member = member;
        this.imageUrl = imageUrl;
    }
}
