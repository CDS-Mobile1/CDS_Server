package com.sopt.instagram.InstagramSERVER.post.service;

import com.sopt.instagram.InstagramSERVER.friend.service.FriendService;
import com.sopt.instagram.InstagramSERVER.member.domain.Member;
import com.sopt.instagram.InstagramSERVER.member.service.MemberService;
import com.sopt.instagram.InstagramSERVER.post.controller.dto.PostCreateDto;
import com.sopt.instagram.InstagramSERVER.post.controller.dto.PostResponseDto;
import com.sopt.instagram.InstagramSERVER.post.domain.Post;
import com.sopt.instagram.InstagramSERVER.post.domain.PostImage;
import com.sopt.instagram.InstagramSERVER.post.repository.PostImageRepository;
import com.sopt.instagram.InstagramSERVER.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostImageRepository postImageRepository;
    private final MemberService memberService;
    private final FriendService friendService;

    @Transactional
    public void create(Long memberId, PostCreateDto postCreateDto) {

        Post newPost = Post.builder()
                .content(postCreateDto.getContent())
                .member(memberService.getMember(memberId)).build();

        List<PostImage> postImageList = postCreateDto.getImageUrlList().stream()
                .map(url -> new PostImage(newPost, url)).collect(Collectors.toList());

        postRepository.save(newPost);
        postImageList.stream().forEach(postImage -> postImageRepository.save(postImage));
    }

    @Transactional
    public List<PostResponseDto> getPostByMemberId(Long memberId) {
        List<Member> followMembers = friendService.getFollowMembers(memberId);
        List<Post> allFollowPosts = followMembers.stream()
                .flatMap(followMember -> followMember.getPosts().stream())
                .collect(Collectors.toList());

        Collections.sort(allFollowPosts, Comparator.comparing(Post::getCreatedAt).reversed());

        return allFollowPosts.stream()
                .map(post -> PostResponseDto.of(post.getMember(), post))
                .collect(Collectors.toList());
    }
}
