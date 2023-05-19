package com.sopt.instagram.InstagramSERVER.post.controller;

import com.sopt.instagram.InstagramSERVER.common.dto.ApiResponseDto;
import com.sopt.instagram.InstagramSERVER.post.controller.dto.PostResponseDto;
import com.sopt.instagram.InstagramSERVER.post.service.PostService;
import com.sopt.instagram.InstagramSERVER.post.controller.dto.PostCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.sopt.instagram.InstagramSERVER.common.exception.SuccessStatus.*;
import static com.sopt.instagram.InstagramSERVER.common.exception.SuccessStatus.POST_CREATE_SUCCESS;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    @PostMapping()
    public ApiResponseDto create(@RequestHeader(value = "Authorization") Long memberId, @RequestBody @Valid final PostCreateDto postCreateDto) {
        postService.create(memberId, postCreateDto);

        return ApiResponseDto.success(POST_CREATE_SUCCESS);
    }

    @GetMapping()
    public ApiResponseDto<List<PostResponseDto>> getPostByMemberId(@RequestHeader(value = "Authorization") Long memberId) {
        return ApiResponseDto.success(READ_POST_BY_MEMBER_SUCCESS, postService.getPostByMemberId(memberId));
    }
}
