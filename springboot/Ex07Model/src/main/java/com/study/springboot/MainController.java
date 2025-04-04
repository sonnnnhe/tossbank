package com.study.springboot;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController { // HttpServlet클래스를 상속받아서, 서블릿 클래스로 등록됨
    @GetMapping("/")  // Request Mapping 코드
    //public String index()
    //public String root()
    public String main() {  // Servlet Method
        //return "index";  // index.html로 응답
        //return "redirect:/index"; // '/index'로 주소 변경
        return "forward:/index";  // 주소 변경x, 화면에 출력되는 내용은 redirect:/index와 동일
    }

    @GetMapping("/index")
    public String index(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        return "index";  // index.html로 응답
    }

    @RequestMapping("/model1")  // 모든 타입(GET/POST/PUT/DELETE 등)의 요청을 받을 수 있음
    public String model1(HttpServletRequest request) {
        request.setAttribute("name", "홍길동");
        request.setAttribute("age", "30");

        request.getSession().setAttribute("isLogin", "true");

        return "index";
    }

    @GetMapping("/post-form")
    public String postform() {
        return "postForm";  // postForm.html 파일을 반환
    }

    @GetMapping("model2")   // GET localhost:8080/model2?name=변사또&age=40
                            // 화면에 index.html, 변사또, 40 출력됨
    @PostMapping("/model2")
    public String model2(HttpServletRequest request) {
        String param_name = request.getParameter("name");  // input태그의 name속성값
        String param_age = request.getParameter("age");
        request.setAttribute("name", param_name);
        request.setAttribute("age", param_age);
        return "index";
    }

    //ModelAndView : 모델(데이터)와 View(HTML)을 동시에 저장하는 객체
    @RequestMapping("/model3")  // localhost:8080/model3
    public ModelAndView model3(HttpServletRequest request, ModelAndView mv) {
        mv.addObject("name", "춘향이");
        mv.addObject("age", "18");
        mv.setViewName("index");  // index.html 렌더
        return mv;
    }
}
