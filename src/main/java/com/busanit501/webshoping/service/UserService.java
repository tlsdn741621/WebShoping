package com.busanit501.webshoping.service;

import com.busanit501.webshoping.domain.Member;

public interface UserService {
    boolean isMemberIdDuplicated(String memberId);
    void registerMember(Member member);
    // 필요하면 다른 회원 관련 메서드도 추가
}