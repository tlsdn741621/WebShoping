package com.busanit501.webshoping.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity

public class Member {
    @Id
    @GeneratedValue
    private Long id;

    private String memberId;
    private String email;
    private String password;
    private String userName;
    private String phone;
}
