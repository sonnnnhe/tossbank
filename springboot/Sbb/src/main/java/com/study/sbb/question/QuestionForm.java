package com.study.sbb.question;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

// 폼 클래스
// 입력값 검증 & 입력 항목 바인딩 시 사용
// 바인딩 : 템플릿의 항목과 form 클래스의 속성이 매핑되는 과정
//         이름이 동일하면 함께 연결되어 묶임 (폼의 바인딩 기능)
// ex) question_form.html의 입력 항목인 subject, content가
//     폼 클래스의 subject, content 속성과 바인딩 됨

@Getter
@Setter
public class QuestionForm {
    // Null 또는 빈 문자열("")을 허용하지 않음  message: 검증 실패 시 뜨는 오류 메세지
    @NotEmpty(message="제목은 필수항목입니다.")
    @Size(max=200) // max : 최대 길이 (byte)
    private String subject;

    @NotEmpty(message="내용은 필수항목입니다.")
    private String content;
}
