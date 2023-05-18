package com.sopt.instagram.InstagramSERVER.friend.controller;

import com.sopt.instagram.InstagramSERVER.common.dto.ApiResponseDto;
import com.sopt.instagram.InstagramSERVER.exception.SuccessStatus;
import com.sopt.instagram.InstagramSERVER.friend.controller.dto.request.UpdateFavoriteStatusDto;
import com.sopt.instagram.InstagramSERVER.friend.controller.dto.response.FriendResponseDto;
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
    public ApiResponseDto<List<FriendResponseDto>> getAllFriendStories(@RequestHeader(value = "Authorization") Long auth) {
        return ApiResponseDto.success(SuccessStatus.READ_ALL_FRIEND_STORY_SUCCESS, friendService.getAllFriendStories(auth));
    }

    @GetMapping("/favorites/stories")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseDto<List<FriendResponseDto>> getAllFavoritesStories(@RequestHeader(value = "Authorization") Long auth) {
        return ApiResponseDto.success(SuccessStatus.READ_FAVORITES_FRIEND_STORY_SUCCESS, friendService.getAllFavoritesStories(auth));
    }

    @PatchMapping("/favorites/{memberId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseDto updateFavoritesStatus(@PathVariable Long memberId, @RequestHeader(value = "Authorization") Long auth, @RequestBody UpdateFavoriteStatusDto request) {
        friendService.updateFavoritesStatus(memberId, auth, request.getIsFavorites());
        return ApiResponseDto.success(SuccessStatus.UPDATE_FAVORITES_STATUS_SUCCESS);
    }
}
