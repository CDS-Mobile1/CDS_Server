package com.sopt.instagram.InstagramSERVER.friend.repository;

import com.sopt.instagram.InstagramSERVER.friend.domain.Friend;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface FriendRepository extends Repository<Friend, Long> {
    List<Friend> findByFollowMemberId(Long friendId);
    List<Friend> findByFollowMemberIdAndIsFavorite(Long friendId, Boolean isFavorite);
    Optional<Friend> findByFollowMemberIdAndFollowedMemberId(Long followId, Long followedId);

}
