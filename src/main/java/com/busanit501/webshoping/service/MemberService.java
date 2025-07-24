package com.busanit501.webshoping.service;

import com.busanit501.webshoping.DTO.MemberDTO;

public interface MemberService {
    void register(MemberDTO dto);
    boolean isMemberIdDuplicated(String memberId);
}
