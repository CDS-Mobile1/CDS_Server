package com.sopt.instagram.InstagramSERVER.story.controller.dto.response;

import com.sopt.instagram.InstagramSERVER.story.domain.Story;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Getter
@AllArgsConstructor(access = PRIVATE)
public class StoryInfoDto {
    private Long storyId;
    private String storyImageUrl;
    private String pastTime;

    public static StoryInfoDto of(Story story) {
        return new StoryInfoDto(story.getId(), story.getImageUrl(), calPastTime(story.getCreatedAt()));
    }

    private static String calPastTime(LocalDateTime createDateTime) {
        Duration duration = Duration.between(createDateTime, LocalDateTime.now());
        long seconds = duration.getSeconds();

        if(seconds < 60) {
            return seconds + "초";
        } else if(seconds < 60*60) {
            return duration.toMinutes() + "분";
        } else {
            return duration.toHours() + "시간";
        }
    }
}
