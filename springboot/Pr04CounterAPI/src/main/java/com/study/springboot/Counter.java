package com.study.springboot;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Counter {
    private int count;
}
