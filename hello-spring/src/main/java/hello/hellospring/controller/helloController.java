package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class helloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!"); // 값을 넣어주고
        return "hello"; // html을 내뱉음. hello.html
        // 컨트롤러에서 리턴 값으로 문자를 반환하면 viewResolver가 화면을 찾아서 처리함.
        // 기본적으로 viewName매핑
        // resources:templates/{viewname}.html
        // spring boot devtools 라이브러리 추가하면 html 파일만 컴파일 하면 서버 재시작없이 뷰 변경 가능
    }
}
