package com.sopt.instagram.InstagramSERVER.friend.service.Impl;

import com.sopt.instagram.InstagramSERVER.friend.controller.dto.response.FriendResponseDto;
import com.sopt.instagram.InstagramSERVER.friend.domain.Friend;
import com.sopt.instagram.InstagramSERVER.friend.repository.FriendRepository;
import com.sopt.instagram.InstagramSERVER.friend.service.FriendService;
import com.sopt.instagram.InstagramSERVER.member.domain.Member;
import com.sopt.instagram.InstagramSERVER.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FriendServiceImpl implements FriendService {

    private final FriendRepository friendRepository;
    private final MemberRepository memberRepository;

    @Override
    public List<FriendResponseDto> getAllFriendStories (Long memberId) {
        return friendRepository.findByFollowMemberId(memberId).stream()
                .map(findFriend -> {
                    Member member = memberRepository.findById(findFriend.getFollowedMember().getId()).orElseThrow();
                    return FriendResponseDto.of(member, findFriend);
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<FriendResponseDto> getAllFavoritesStories (Long memberId) {
        return friendRepository.findByFollowMemberIdAndIsFavorite(memberId, true).stream()
                .map(findFriend -> {
                    Member member = memberRepository.findById(findFriend.getFollowedMember().getId()).orElseThrow();
                    return FriendResponseDto.of(member.getId(), member.getProfileUrl(), member.getName(), findFriend.getIsSpecial());
                })
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void updateFavoritesStatus(Long memberId, Long auth, boolean isFavorite) {
        Friend findFriend = friendRepository.findByFollowMemberIdAndFollowedMemberId(auth, memberId).orElseThrow();
        findFriend.changeFavoriteStatus(isFavorite);
    }
}
