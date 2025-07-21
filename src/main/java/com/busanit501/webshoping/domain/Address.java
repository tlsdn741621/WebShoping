package com.busanit501.webshoping.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {
    @Id @GeneratedValue
    private Long id;

    private String zipcode;
    private String addressId;
    private String addressLine;

    private boolean isDefault; // 기본 배송지 여부

    // N(배송지) : 1(회원)
    // 하나의 회원에 여러개의 배송지를 입력할 수 있도록 만들겠습니다.
    @ManyToOne
    private Member member;
}
