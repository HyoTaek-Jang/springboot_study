package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
//    private DataSource dataSource;
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    @Bean // 스프링 빈에 등록하라는 뜻
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return new JpaMemberRepository(em);
//        return new JdbcTemplateMemberRepository(dataSource);
//    }
//    public MemberRepository memberRepository() {
//        return new JdbcMemberRepository(dataSource);
//    }
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }

//    @Bean
//    public TimeTraceAop TimeTraceAop() {
//        return new TimeTraceAop();
//    }
}
