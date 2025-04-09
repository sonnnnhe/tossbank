package com.study.sbb.question;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// 리포지토리
// : 생성된 DB 테이블의 데이터들을 저장, 조회, 수정, 삭제 등을 할 수 있도록 도와주는 인터페이스
//   테이블 접근, 데이터 관리 메소드를 제공 (findAll, save 등)

// JpaRepository : JPA가 제공하는 인터페이스
//                 CRUD 작업을 처리하는 메서드 내장되어 있음
// JpaRepository<Question, Integer> : Question 엔티티로 리포지토리 생성한다는 의미
//                                    Question 엔티티의 기본키가 Integer임
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findBySubject(String subject);  // where문 조건으로 subject 포함
    Question findBySubjectAndContent(String subject, String content); // where문에 and 연산자로 subject, content열 조회
    List<Question> findBySubjectLike(String subject);
}
