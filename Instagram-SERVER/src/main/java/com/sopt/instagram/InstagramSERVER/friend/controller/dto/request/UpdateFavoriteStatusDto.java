package com.sopt.instagram.InstagramSERVER.friend.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.*;

@Getter
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor
public class UpdateFavoriteStatusDto {
    private Boolean isFavorites;
}
