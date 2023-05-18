package com.sopt.instagram.InstagramSERVER.friend.repository;

import com.sopt.instagram.InstagramSERVER.friend.domain.Friend;
import com.sopt.instagram.InstagramSERVER.member.domain.Member;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface FriendRepository extends Repository<Friend, Long> {
    List<Friend> findByFollowMemberId(Long friendId);
}
