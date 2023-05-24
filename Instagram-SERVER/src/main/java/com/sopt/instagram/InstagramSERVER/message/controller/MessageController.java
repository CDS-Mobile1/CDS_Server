package com.sopt.instagram.InstagramSERVER.message.controller;

import com.sopt.instagram.InstagramSERVER.common.dto.ApiResponseDto;
import com.sopt.instagram.InstagramSERVER.message.controller.dto.MessageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static com.sopt.instagram.InstagramSERVER.common.exception.SuccessStatus.READ_ALL_MESSAGE_SUCCESS;

@RestController
@RequiredArgsConstructor
public class MessageController {

    @GetMapping("/api/message")
    public ApiResponseDto getMessages(@RequestHeader(value = "Authorization") Long memberId) {

        MessageResponseDto m2 = MessageResponseDto.of(2L, "https://img1.daumcdn.net/thumb/R1280x0.fjpg/?fname=http://t1.daumcdn.net/brunch/service/user/cnoC/image/zEhZ2awRcQW18YL-RfpDDNPbcJs.PNG",
                "95_jihye", "너 지금 뭐해?", true, true, false);
        MessageResponseDto m3 = MessageResponseDto.of(3L, "https://i.namu.wiki/i/xxBfo7GxFVs8dGFBDBjIes-HxgQJTICsWOuc0VR7Dy95cU0EsL6UAVSJ3vGPUWOsxJVK7WC9cAYXE1WXGKdbKw.webp",
                "anchoby", "아닠ㅋㅋㅋ 그니까 개웃김", false, true, false);
        MessageResponseDto m4 = MessageResponseDto.of(4L, "https://image.kmib.co.kr/online_image/2017/0630/201706301354_61120011580386_1.jpg",
                "na_bbol", "고솝트 짱! 클디서 합동세미나 짱! 너무 설렌다 정말로 진짜 제발", true, false, false);
        MessageResponseDto m5 = MessageResponseDto.of(5L, "https://file2.nocutnews.co.kr/newsroom/image/2023/04/06/202304061036358815_0.jpg",
                "ye_ssseul", "고양이 귀여워", false, false, false);
        MessageResponseDto m6 = MessageResponseDto.of(6L, "https://interactive.hankookilbo.com/v/anilog_mbti/assets/img/dog_ENFJ.png",
                "sung_silver", "내일 여기 ㅋㅋ", false, false, false);
        MessageResponseDto m7 = MessageResponseDto.of(7L, "https://cdn-icons-png.flaticon.com/512/1998/1998809.png",
                "ddong-gyu", "너 왜 아직도 안 잠 ㄷㄷ 빨리 자 지금 시간 개 늦었어", false, true, false);

        List<MessageResponseDto> messageList = Arrays.asList(m2, m3, m4, m5, m6, m7);
        return ApiResponseDto.success(READ_ALL_MESSAGE_SUCCESS, messageList);
    }
}