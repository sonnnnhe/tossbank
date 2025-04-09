package com.study.sbb.question;

import com.study.sbb.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service  // QuestionService 클래스를 서비스로 지정
public class QuestionService {
    private final QuestionRepository questionRepository;

    // 질문 목록 데이터 조회 후 리턴하는 getList 메서드
    public List<Question> getList() {
        return this.questionRepository.findAll();
    }

    // id 값으로 질문 데이터 조회
    public Question getQeustion(Integer id) {
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }

    // 질문 저장
    public void create(String subject, String content) {
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q);
    }
}
