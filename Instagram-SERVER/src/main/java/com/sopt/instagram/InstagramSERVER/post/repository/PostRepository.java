package com.sopt.instagram.InstagramSERVER.post.repository;

import com.sopt.instagram.InstagramSERVER.post.domain.Post;
import org.springframework.data.repository.Repository;

public interface PostRepository extends Repository<Post, Long> {

    void save(Post post);

}
