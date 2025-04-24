package com.study.springboot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CalcDto {
    private String num1;
    private String num2;
    private String calType;
}
