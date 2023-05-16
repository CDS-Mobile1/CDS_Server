package com.sopt.instagram.InstagramSERVER.member.repository;


import com.sopt.instagram.InstagramSERVER.member.domain.Member;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface MemberRepository extends Repository<Member, Long> {

    Optional<Member> findById(Long id);
}
