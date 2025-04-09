package com.study.sbb.question;

import com.study.sbb.answer.AnswerForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/question")
@RequiredArgsConstructor  // questionRepository 객체 주입
// : final이 붙은 속성을 포함하는 생성자를 자동으로 만들어 줌
@Controller
public class QuestionController {
    /* private final QuestionRepository questionRepository;

    @GetMapping("/question/list")
    //                 Model 객체 : 따로 생성할 필요 없이 매개변수로 지정하기만 하면 자동 생성됨
    public String list(Model model) {
        List<Question> questionList = this.questionRepository.findAll();
        // model 객체에 담아둔 값을 template 에서 사용 가능
        model.addAttribute("questionList", questionList);
        return "question_list";
    } */

    // 리포지토리를 바로 사용하기 보다 서비스를 사용하는 게 좋음
    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }

    // 질문 상세 페이지
    @GetMapping("/detail/{id}")
                                    // ~/{id}에서 사용한 id와 @PathVariable("id")의 매개변수 이름이 동일
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
        // Question 객체를 템플릿에 전달
        Question question = this.questionService.getQeustion(id);
        model.addAttribute("question", question);

        return "question_detail";
    }

    // 질문 등록 페이지
    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }

    // 질문 저장 POST 요청 처리
    @PostMapping("/create")
                                // : QuestionForm의 @NotEmpty, @Size등 설정한 검증 기능이 동작
    public String questionCreate(@Valid QuestionForm questionForm,
                                 BindingResult bindingResult) {
                                // : @Valid 애너테이션으로 검증이 수행된 결과를 의미하는 객체
                                // => BindingResult 매개변수는 항상 @Valid 뒤에 위치해야 한다.
                                //     Why? @Valid만 적용되어 입력값 검증 실패 시 400 오류 발생
        if (bindingResult.hasErrors()) {
            return "question_form";  // 오류 발생 시 다시 질문 작성 화면으로 돌아감
        }
        // 질문 저장
        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list";  // 질문 저장 후 질문목록으로 이동
    }
}
