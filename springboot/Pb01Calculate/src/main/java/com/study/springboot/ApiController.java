package com.study.springboot;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
public class ApiController {
    @PostMapping("/calculate")
    public ResDto calculate(@RequestBody ReqDto reqDto) {
        System.out.println("num1 = " + reqDto.getNum1());
        System.out.println("num2 = " + reqDto.getNum2());
        System.out.println("operation = " + reqDto.getOperation());

        String operation = reqDto.getOperation();
        int num1 = reqDto.getNum1();
        int num2 = reqDto.getNum2();

        ResDto resDto = new ResDto();
        switch(operation) {
            case "add":
                resDto.setResult(num1 + num2);
                break;
            case "subtract":
                resDto.setResult(num1 - num2);
                break;
            case "multiply":
                resDto.setResult(num1 * num2);
                break;
            case "divide":
                resDto.setResult(num1 / num2);
                break;
        }

        return resDto;
    }
}
