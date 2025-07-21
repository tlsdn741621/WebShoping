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
        return "member/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute MemberDTO memberDTO) {
        memberService.register(memberDTO);
        return "redirect:/login";
    }
}
