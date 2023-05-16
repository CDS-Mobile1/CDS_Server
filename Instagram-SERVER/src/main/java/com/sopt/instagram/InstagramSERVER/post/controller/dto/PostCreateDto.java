package com.sopt.instagram.InstagramSERVER.post.controller.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostCreateDto {

    private String content;
    private ArrayList<String> imageUrlList;
}
