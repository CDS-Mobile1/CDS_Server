package com.sopt.instagram.InstagramSERVER.post.domain;

import lombok.*;

import javax.persistence.*;


@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_image_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Column(nullable = false)
    private String imageUrl;

    public PostImage(Post post, String url) {
        this.post = post;
        this.imageUrl = url;
    }
}
