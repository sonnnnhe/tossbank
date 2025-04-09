package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private Counter counter;

    @GetMapping("/plus")
    public @ResponseBody Counter plus() {
        counter.setCount(counter.getCount() + 1);
        return counter;
    }

    @GetMapping("/minus")
    public @ResponseBody Counter minus() {
        counter.setCount(counter.getCount() - 1);
        return counter;
    }
}
