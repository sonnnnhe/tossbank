package com.study.sbb;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

                        // HTTP 상태 코드               // 이유
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "entity not found")
public class DataNotFoundException extends  RuntimeException {
    // RunTimeException 클래스 상속 : 사용자 정의 예외 클래스 정의 방법 중 하나
    private static final long serialVersionUID  = 1L;
    public DataNotFoundException(String message) {
        super(message);
    }

}
