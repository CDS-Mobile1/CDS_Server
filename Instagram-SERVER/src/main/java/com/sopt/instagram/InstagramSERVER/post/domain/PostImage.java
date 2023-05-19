package com.sopt.instagram.InstagramSERVER.post.domain;

import com.sopt.instagram.InstagramSERVER.common.domain.TimeStamped;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.*;


@Getter
@Entity
@NoArgsConstructor(access = PROTECTED)
public class PostImage extends TimeStamped {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "post_image_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Column(nullable = false)
    private String imageUrl;

    @Builder
    public PostImage(Post post, String url) {
        this.post = post;
        this.imageUrl = url;
        this.post.addPostImage(this);
    }
}
