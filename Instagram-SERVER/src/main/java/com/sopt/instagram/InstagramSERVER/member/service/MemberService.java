package com.sopt.instagram.InstagramSERVER.member.service;

import com.sopt.instagram.InstagramSERVER.common.exception.BusinessException;
import com.sopt.instagram.InstagramSERVER.member.repository.MemberRepository;
import com.sopt.instagram.InstagramSERVER.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.sopt.instagram.InstagramSERVER.common.exception.ErrorStatus.MEMBER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public Member getMember(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new BusinessException(MEMBER_NOT_FOUND));
    }

}
