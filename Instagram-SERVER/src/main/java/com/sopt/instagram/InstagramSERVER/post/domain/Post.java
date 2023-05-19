package com.sopt.instagram.InstagramSERVER.post.domain;

import com.sopt.instagram.InstagramSERVER.common.domain.TimeStamped;
import com.sopt.instagram.InstagramSERVER.member.domain.Member;
import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

@Getter
@Entity
@NoArgsConstructor(access = PROTECTED)
public class Post extends TimeStamped {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    private String content;

    @OneToMany(mappedBy = "post", cascade = ALL)
    private List<PostImage> postImages = new ArrayList<>();

    @Builder
    public Post(Member member, String content) {
        this.member = member;
        this.content = content;
        this.member.addPost(this);
    }

    public void addPostImage(PostImage postImage) {
        postImages.add(postImage);
    }
}
