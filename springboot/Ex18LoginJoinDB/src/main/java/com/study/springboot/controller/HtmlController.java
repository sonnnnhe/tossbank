package com.study.springboot.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {
    @GetMapping("/")
    public String main(HttpSession session) {
        // 로그인 성공 시 액션
        session.setAttribute("isLogin", true);
        session.setAttribute("userId", "GilDong");

        return "index";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "loginForm";
    }
    @GetMapping("/loginAction")
    public String logoutAction() {
        return "index";
    }

    @GetMapping("/logoutAction")
    public String logoutAction(HttpSession session) {
        session.invalidate();
        return "index";
    }
}
