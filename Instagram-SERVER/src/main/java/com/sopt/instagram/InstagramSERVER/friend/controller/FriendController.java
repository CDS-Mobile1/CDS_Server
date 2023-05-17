package com.sopt.instagram.InstagramSERVER.friend.controller;

import com.sopt.instagram.InstagramSERVER.common.dto.ApiResponseDto;
import com.sopt.instagram.InstagramSERVER.exception.SuccessStatus;
import com.sopt.instagram.InstagramSERVER.friend.controller.dto.FriendResponseDto;
import com.sopt.instagram.InstagramSERVER.friend.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/friend")
public class FriendController {

    private final FriendService friendService;

    @GetMapping("/stories")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseDto<List<FriendResponseDto>> getAllFriendStories(@RequestHeader(value = "Authorization") Long memberId) {
        return ApiResponseDto.success(SuccessStatus.READ_ALL_FRIEND_STORY_SUCCESS, friendService.getAllFriendStories(memberId));
    }
}
