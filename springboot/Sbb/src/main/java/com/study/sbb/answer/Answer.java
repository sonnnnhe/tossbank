package com.study.sbb.answer;

import com.study.sbb.question.Question;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    // 질문 엔티티를 참조하기 위한 속성
    // 답변-질문 => N:1 관계
    @ManyToOne   // 답변 엔티티의 question 속성과 질문 엔티티가 서로 연결됨 (외래키)
    private Question question;
    // 답변을 통해 질문의 제목을 알고 싶다면?
    // => answer.getQuestion().getSubject();

    // @ManyToOne
    //  : 부모 자식 관계를 갖는 구조에서 사용
    //    여기서 부모 = Question, 자식 = Answer
}
