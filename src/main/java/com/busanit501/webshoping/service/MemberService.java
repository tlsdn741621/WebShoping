package com.busanit501.webshoping.service;

import com.busanit501.webshoping.DTO.MemberDTO;
import com.busanit501.webshoping.domain.Address;
import com.busanit501.webshoping.domain.Member;
import com.busanit501.webshoping.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(MemberDTO dto) {
        Member member = new Member();
        member.setMemberId(dto.getMemberId());
        member.setPassword(passwordEncoder.encode(dto.getPassword()));
        member.setEmail(dto.getEmail());
        member.setUserName(dto.getUserName());
        member.setPhone(dto.getPhone());
        member.setBirthDate(dto.getBirthDate());

        if (dto.isRegisterAddress()) {
            Address address = new Address();
            address.setZipcode(dto.getZipcode());
            address.setAddressLine(dto.getAddressLine());
            address.setAddressId(dto.getAddressId());
            address.setDefault(true);
            address.setMember(member);
        }

        memberRepository.save(member);
    }
}
