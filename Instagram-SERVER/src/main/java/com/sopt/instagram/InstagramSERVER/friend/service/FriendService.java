package com.sopt.instagram.InstagramSERVER.friend.service;

import com.sopt.instagram.InstagramSERVER.friend.controller.dto.response.FriendResponseDto;

import java.util.List;

public interface FriendService {

    //* 팔로우한 유저 스토리 목록 조회
    List<FriendResponseDto> getAllFriendStories(Long memberId);

    //* 즐겨찾기한 유저 스토리 목록 조회
    List<FriendResponseDto> getAllFavoritesStories(Long memberId);

    //* 즐겨찾기 변경
    void updateFavoritesStatus(Long memberId, Long auth, boolean isFavorites);

}
