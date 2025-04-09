package com.study.springboot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    // 생성자 주입
    private final MemberRepostiory memberRepostiory;

    // 필드 주입
    // @Autowired
    // private MemberRepostiory memberRepostiory;

    @GetMapping("/")
    public String main(Model model) {
        System.out.println("memberRepository = " + memberRepostiory);

        memberRepostiory.save(new MemberEntity(Long.valueOf(1),
                "hong", "1234", "홍길동2", "ROLE_USER", LocalDate.now()));
        memberRepostiory.save(new MemberEntity(null,
                "tom", "5678", "톰아저씨", "ROLE_USER", LocalDate.now()));

        List<MemberEntity> list = memberRepostiory.findAll();
        System.out.println("list.size() = " + list.size());

        model.addAttribute("list", list);

        return "index";  // index.html로 응답
    }
}
