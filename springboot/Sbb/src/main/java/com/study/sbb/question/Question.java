package com.study.sbb.question;

import com.study.sbb.answer.Answer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
// Question 클래스를 엔티티로 인식시키기 위함
@Entity
public class Question {

    /* 질문 엔티티 생성 */
    @Id   // id 속성 기본키 지정
                               // 자동으로 1씩 증가하여 저장
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // startegy 생략 시 @GenerationValue 애너테이션이 지정된 모든 속성에 번호를 차례로 생성
    // => 순서가 일정한 고유 번호를 가질 수 없게 됨!!!
    private Integer id;

    // length : 열의 길이
    @Column(length = 200)
    private String subject;

    // columnDefinition : 열 데이터의 유형이나 성격 정의
    // ex) columnDefinition = "TEXT" : '텍스트'를 열 데이터로 넣을 수 있고, 글자 수 제한 X
    @Column(columnDefinition = "TEXT")
    private String content;

    // createDate => create_date 열 이름
    private LocalDateTime createDate;

    // 질문-답변 => 1:N 관계, OneToMany
    //        mappedBy : 참조 엔티티의 속성명 정의
    //        cascade = CascadeType;REMOVE : 질문 삭제 시 관련 답변들도 다 삭제
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;  // Answer 객체 배열
    // 질문에서 답변 참조 : question.getAnswerList();



    // 엔티티의 속성은 @Column 애너테이션을 사용하지 않더라도
    // 테이블의 열로 인식한다.
    // @Transient 애너테이션 사용 시, 테이블의 열로 인식 X
    //           => 엔티티의 속성을 클래스의 속성 기능으로만 사용하고자 할 때 씀

    // 엔티티 생성 시 Setter 사용 자제
    //    데이터베이스와 엔티티는 바로 연결되므로 데이터 변경이 자유로운
    //    Setter의 사용이 안전하지 않음
    //    => 생성자에 의해서만 엔티티 값 저장 & 변경 필요한 경우에는 메서드를 추가 작성
}
