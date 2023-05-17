package com.sopt.instagram.InstagramSERVER.post.domain;

import com.sopt.instagram.InstagramSERVER.member.domain.Member;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    private String content;

    @Builder
    public Post(Member member, String content) {
        this.member = member;
        this.content = content;
    }
}
