package com.sopt.instagram.InstagramSERVER.member.domain;

import com.sopt.instagram.InstagramSERVER.story.domain.Story;
import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@NoArgsConstructor(access = PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    private String profileUrl;

    @Builder
    public Member(String name, String profileUrl) {
        this.name = name;
        this.profileUrl = profileUrl;
    }

    public void setDefaultImage() {
        this.profileUrl = "https://imson.imweb.me/common/img/default_profile.png";
    }
}
