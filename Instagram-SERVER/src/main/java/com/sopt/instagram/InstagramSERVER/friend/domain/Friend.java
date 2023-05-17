package com.sopt.instagram.InstagramSERVER.friend.domain;

import com.sopt.instagram.InstagramSERVER.member.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Friend {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "friend_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "follow_member_id")
    private Member followMember;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "followed_member_id")
    private Member followedMember;

    @Column(nullable = false, name = "is_favorite")
    private Boolean isFavorite;

    @Column(nullable = false, name = "is_special")
    private Boolean isSpecial;

    @Builder
    public Friend(Member followMember, Member followedMember, Boolean isFavorite, Boolean isSpecial) {
        this.followMember = followMember;
        this.followedMember = followedMember;
        this.isFavorite = isFavorite;
        this.isSpecial = isSpecial;
    }
}
