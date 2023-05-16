package com.sopt.instagram.InstagramSERVER.member.service;

import com.sopt.instagram.InstagramSERVER.member.repository.MemberRepository;
import com.sopt.instagram.InstagramSERVER.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public Member getMember() {
        return memberRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("해당 멤버가 없습니다."));
    }
}
