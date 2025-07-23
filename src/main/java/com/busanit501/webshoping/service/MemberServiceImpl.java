package com.busanit501.webshoping.service;

import com.busanit501.webshoping.DTO.MemberDTO;
import com.busanit501.webshoping.domain.Address;
import com.busanit501.webshoping.domain.Member;
import com.busanit501.webshoping.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(MemberDTO dto) {
        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(dto.getPassword());

        // Member 엔티티 생성 (Builder 사용)
        Member member = Member.builder()
                .memberId(dto.getMemberId())
                .email(dto.getEmail())
                .password(encodedPassword)
                .userName(dto.getUserName())
                .phone(dto.getPhone())
                .birthDate(dto.getBirthDate())
                .createdAt(LocalDateTime.now())
                .build();

        // 주소 정보가 있다면 Address 생성
        if (dto.isRegisterAddress()) {
            Address address = Address.builder()
                    .zipcode(dto.getZipcode())
                    .addressId(dto.getAddressId())
                    .addressLine(dto.getAddressLine())
                    .createdAt(LocalDateTime.now())
                    .isDefault(true)
                    .member(member) // 연관 관계 설정
                    .build();

            member.getAddresses().add(address);
        }

        // member 저장 (address도 cascade 설정 되어 있어야 자동 저장됨)
        memberRepository.save(member);
    }

    @Override
    public boolean isMemberIdDuplicated(String memberId) {
        return memberRepository.existsByMemberId(memberId);
    }
}