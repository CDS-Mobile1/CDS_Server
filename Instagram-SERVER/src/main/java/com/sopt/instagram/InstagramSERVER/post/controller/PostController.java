package com.sopt.instagram.InstagramSERVER.post.controller;

import com.sopt.instagram.InstagramSERVER.common.dto.ApiResponseDto;
import com.sopt.instagram.InstagramSERVER.post.service.PostService;
import com.sopt.instagram.InstagramSERVER.post.controller.dto.PostCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.sopt.instagram.InstagramSERVER.exception.SuccessStatus.POST_CREATE_SUCCESS;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/api/post")
    public ApiResponseDto create(@RequestBody @Valid final PostCreateDto postCreateDto) {
        postService.create(postCreateDto);

        return ApiResponseDto.success(POST_CREATE_SUCCESS);
    }
}
