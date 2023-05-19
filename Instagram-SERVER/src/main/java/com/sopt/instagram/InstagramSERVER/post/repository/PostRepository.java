package com.sopt.instagram.InstagramSERVER.post.repository;

import com.sopt.instagram.InstagramSERVER.post.domain.Post;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface PostRepository extends Repository<Post, Long> {

    void save(Post post);

    List<Post> findByMemberId(Long memberId);

}
