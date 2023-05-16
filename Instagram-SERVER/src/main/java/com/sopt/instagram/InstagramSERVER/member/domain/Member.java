package com.sopt.instagram.InstagramSERVER.member.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    private String profileUrl;

    public void setDefaultImage() {
        this.profileUrl = "https://imson.imweb.me/common/img/default_profile.png";
    }
}
