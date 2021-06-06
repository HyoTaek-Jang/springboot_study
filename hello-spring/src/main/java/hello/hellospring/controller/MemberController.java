package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
//    스프링 컨테이너에서 멤버서비스를 가져오느거야! 굳이 여러개 만들필요가 없는 놈이니까!! 컨트롤러마다 생성할 수 없자나,
//    DI!! 멤버 컨트롤러가 생성될때 스프링 빈에 등록된 멤버 서비스 객체를 넣어줌!! Dependency injection
//    컴포넌트 스캔 방식!
//    스프링이 빈 등록할땐 싱글톤 방식으로 1개만 등록함
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
