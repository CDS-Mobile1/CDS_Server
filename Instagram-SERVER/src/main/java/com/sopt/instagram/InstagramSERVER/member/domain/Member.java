package com.sopt.instagram.InstagramSERVER.member.domain;

import com.sopt.instagram.InstagramSERVER.common.domain.TimeStamped;
import com.sopt.instagram.InstagramSERVER.post.domain.Post;
import com.sopt.instagram.InstagramSERVER.story.domain.Story;
import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@NoArgsConstructor(access = PROTECTED)
public class Member extends TimeStamped {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    private String profileUrl;

    @OneToMany(mappedBy = "member", cascade = ALL)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = ALL)
    private List<Story> stories = new ArrayList<>();

    @Builder
    public Member(String name, String profileUrl) {
        this.name = name;
        this.profileUrl = profileUrl;
    }

    public void setDefaultImage() {
        this.profileUrl = "https://imson.imweb.me/common/img/default_profile.png";
    }

    public void addPost(Post post) { posts.add(post); }

    public void addStory(Story story) { stories.add(story); }

    public boolean getStoryExists() {
        return !stories.isEmpty();
    }
}
