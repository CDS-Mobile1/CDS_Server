package com.sopt.instagram.InstagramSERVER.post.repository;

import com.sopt.instagram.InstagramSERVER.post.domain.PostImage;
import org.springframework.data.repository.Repository;

public interface PostImageRepository extends Repository<PostImage, Long> {

    void save(PostImage postImage);
}
