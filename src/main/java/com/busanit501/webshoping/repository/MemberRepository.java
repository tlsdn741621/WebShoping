package com.busanit501.webshoping.repository;

import com.busanit501.webshoping.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByMemberId(String memberId);
}
