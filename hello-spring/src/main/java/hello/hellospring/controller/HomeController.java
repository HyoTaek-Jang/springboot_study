package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

//    먼저 컨테이너에서 컨트롤러를 찾고 없으면 static index를 찾는거임.
    @GetMapping("/")
    public String home() {
        return "home";
    }

}
