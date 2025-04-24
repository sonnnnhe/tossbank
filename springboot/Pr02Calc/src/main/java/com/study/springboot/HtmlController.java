package com.study.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HtmlController {
    @GetMapping("/")
    public String main() {
        return "calc";
    }

    @GetMapping("/calc-submit")
    public String clac(CalcDto calcDto,
                       Model model) {
        int num1 = Integer.parseInt(calcDto.getNum1());
        int num2 = Integer.parseInt(calcDto.getNum2());
        String calType = calcDto.getCalType();

        int result = 0;
        switch (calType) {
            case "add":
                result = num1 + num2;
                break;
            case "sub":
                result = num1 - num2;
                break;
            case "mul":
                result = num1 * num2;
                break;
            case "div":
                result = num1 / num2;
                break;
            default:
                break;
        }

        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("result", result);

        return "calc";
    }
}
