package com.busanit501.webshoping.controller;

import com.busanit501.webshoping.DTO.MemberDTO;
import com.busanit501.webshoping.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("memberDTO", new MemberDTO());
        return "board/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute MemberDTO memberDTO, Model model) {
        // 비밀번호 확인 필드를 DTO에 추가했다고 가정 (없으면 아래처럼 따로 받을 수도 있음)
        if (!memberDTO.getPassword().equals(memberDTO.getConfirmPassword())) {
            model.addAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
            model.addAttribute("memberDTO", memberDTO);
            return "board/register"; // 다시 회원가입 폼으로 이동
        }

        memberService.register(memberDTO);
        return "redirect:/login";
    }
}
