package hello.hellospring.controller;

import hello.hellospring.HelloSpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // res body에 값을 넣어주겠다!
    public String helloString(@RequestParam(value = "name", required = false) String name, Model model){
//        model.addAttribute("name",name);
        return "hello"+name;
    }

    @GetMapping("hello-get")
    @ResponseBody // 객체반환!
    public Hello helloApi(@RequestParam(value = "name") String name,Model model){
        Hello hello = new Hello();
        hello.setName(name);

        return hello;
    }

    static class Hello {
        private String name;
        private String num = "123";

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public String getNum() {
            return num;
        }

        // 쉬프트 두번 누르고 getter setter 검색하면 빠르게 가능
// json 변경은 자바빈 프로퍼티 방식임!! 게터가 있어야하는듯
    }


}
