package com.study.springboot;

import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

// @Value의 용도
// 1. springframework의 @Value
//   1) application의 설정값을 주입하는 용도
// 2. lombok의 @Value
//   1) final, private, getter, equals, toString 등이 생성됨.

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    // ORM Mapping
    //   login_form.html의 input 태그의 속성 이름과
    //   변수의 이름이 동일하므로.. mapping 가능..
    @Value("${my.username}")
    String username;
    @Value("${my.password}")
    String password;
}
