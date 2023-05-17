package com.sopt.instagram.InstagramSERVER.post.domain;

import com.sopt.instagram.InstagramSERVER.member.domain.Member;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

@Getter
@Entity
@NoArgsConstructor(access = PROTECTED)
public class Post {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    private String content;

    @Builder
    public Post(Member member, String content) {
        this.member = member;
        this.content = content;
    }
}
