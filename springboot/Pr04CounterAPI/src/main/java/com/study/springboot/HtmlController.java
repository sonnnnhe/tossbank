package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {
    @Autowired
    private Counter counter;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("count", counter.getCount());
        return "counter";
    }
}
