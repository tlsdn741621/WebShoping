package com.busanit501.webshoping.controller;

import com.busanit501.webshoping.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @GetMapping("/check-id")
    public Map<String, Boolean> checkIdDuplicate(@RequestParam String memberId) {
        boolean isDuplicate = memberService.isMemberIdDuplicated(memberId);
        return Collections.singletonMap("duplicate", isDuplicate);
    }
}
