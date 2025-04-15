package com.study.sbb;

import com.study.sbb.answer.AnswerRepository;
import com.study.sbb.question.QuestionRepository;
import com.study.sbb.question.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbbApplicationTests {
	// 질문 객체
	@Autowired  // 스프링 부트가 questionRepository 객체를 자동으로 만들어 주입
	private QuestionRepository questionRepository;

	// 답변 객체
	@Autowired
	private AnswerRepository answerRepository;

	@Autowired
	private QuestionService questionService;

//	@Transactional   // Test코드에서는 DB 세션이 종료될 수 있어서 오류 방지 (메서드 종료까지 DB세션 유지시킴)
	@Test
	void testJpa() {
		// q1, q2라는 질문 엔티티의 객체 생성 후 questionRepository를 이용하여 DB에 저장
		/* Question q1 = new Question();
		q1.setSubject("sbb가 무엇인가요?");
		q1.setContent("sbb에 대해서 알고 싶습니다.");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);  // 첫번째 질문 저장

		Question q2 = new Question();
		q2.setSubject("스프링부트 모델 질문입니다.");
		q2.setContent("id는 자동으로 생성되나요?");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);  // 두번째 질문 저장 */


		// question 테이블에 저장된 모든 데이터 조회
		/* List<Question> all = this.questionRepository.findAll();
		assertEquals(2, all.size());  // 데이터 사이즈 확인 (예상 결과와 실제 결과 동일 여부 확인)
									          // assertEquals(기댓값, 실젯값)
		Question q = all.get(0);
		assertEquals("sbb가 무엇인가요?", q.getSubject()); */


		// findById 메서드
		// return 타입 : Optional (null값을 유연하게 처리하기 위한 클래스)
		/* Optional<Question> oq = this.questionRepository.findById(1);
		// isPresent() : 값 존재 여부 확인
		if (oq.isPresent()) {
			Question q = oq.get();   // get() : Question 값 가져오기
			assertEquals("sbb가 무엇인가요?", q.getSubject());
		} */


		// findBySubject 메서드
		// 기본적으로 제공 X, QuestionRepository 인터페이스 변경 필요
		/* Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
		assertEquals(1, q.getId()); */


		// findBySubjectAndContent 메서드
		// 기본적으로 제공 X, QuestionRepository 인터페이스 변경 필요
		/* Question q = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
		assertEquals(1, q.getId()); */
		// 이외에도 Or, Between, LessThan, GreaterThanEqual, Like, In, OrderBy로 조합 가능


		// findBySubjectLike 메서드
		/* List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
		Question q = qList.get(0); */


		// 질문 데이터 수정하기
		/* Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());  // assertTrue(): 괄호 안의 값인지 참인지 확인
		Question q = oq.get();
		q.setSubject("수정된 제목");
		this.questionRepository.save(q); */


		// 질문 데이터 삭제하기
		/* assertEquals(2, this.questionRepository.count());
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		this.questionRepository.delete(q);
		assertEquals(1, this.questionRepository.count());  // 삭제 됐는지 확인 */

		/* ------------------------------------------ */

		// 답변 데이터 저장하기
		//   답변 생성하려면 질문이 필요
		/* Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();

		Answer a = new Answer();
		a.setContent("네 자동으로 생성됩니다.");
		a.setQuestion(q);
		a.setCreateDate(LocalDateTime.now());
		this.answerRepository.save(a); */


		// 답변 데이터 조회하기
		/* Optional<Answer> oa = this.answerRepository.findById(1);
		assertTrue(oa.isPresent());
		Answer a = oa.get();
		assertEquals(2, a.getQuestion().getId()); */

		// 답변 데이터를 통해 질문 데이터 찾기 VS 질문 데이터를 통해 답변 데이터 찾기
		// 		답변 데이터를 통해 질문 데이터 찾기
		//		: a.getQuestion()   - a : 답변 객체
		/* Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();

		List<Answer> answerList = q.getAnswerList();

		assertEquals(1, answerList.size());
		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent()); */

		// 300개의 테스트 데이터 생성
		for (int i = 1; i <= 300; i++) {
			String subject = String.format("테스트 데이터입니다:[%03d]", i);
			String content = "내용무";
			this.questionService.create(subject, content);
		}
	}

}
