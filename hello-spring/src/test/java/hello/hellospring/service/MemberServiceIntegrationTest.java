package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*

단위테스트가 좋은 테스트일 확률이 높다. 이건 스프링 컨테이너를 띄우는 통합테스트

단위 테스트는 주로 서비스 로직에 적용합니다. 그런데 DB를 연동하면 이제 단위 테스트가 어려워지지요.

그래서 테스트 전용 가짜 repository를 만들어서 테스트 시점에 넣어주어야 합니다. 이것을 mock 객체라고 합니다.

단순히 테스트를 위해서 진짜 db가 아니라 가짜 객체를 하나 만들어서 넣어준다고 생각하시면 됩니다.

그런데 일일이 이런 객체를 만들면 개발자가 너무 귀찮으니까 실무에서는 mockito 같은 가짜 객체를 만들어주는 라이브러리를 주로 사용합니다.

 */

@SpringBootTest
// 검증을 다 하고 롤백하는거임. 테스트 실행할떄 트랙잭션을 실행하고, db 데이터를 넣고, 테스트 끝나면 롤백함. 데이터가 안들어가는거지
@Transactional
class MemberServiceIntegrationTest {

//    테스트는 편하게 그냥 인젝션 오도와이어로 편하게 해도 됨
    @Autowired MemberService memberService;
    @Autowired
    MemberRepository memberRepository;


    @Test
    void join() {
        //given
        // 이런 상황이 주어졌을때
        Member member = new Member();
        member.setName("test");


        //when
        // 이거로 실행했을때
        Long saveId = memberService.join(member);


        //then
        // 결과로 이게 나와야함
        Optional<Member> findMember = memberService.findOne(saveId);
        assertThat(member.getName()).isEqualTo(findMember.get().getName());
    }

    @Test
    public void duplicatedMember() {
        //given
        Member member1 = new Member();
        member1.setName("spring3");

        Member member2 = new Member();
        member2.setName("spring3");

        //when
        memberService.join(member1);
//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        람다로직을 돌렸을때 저 에러가 떠야함!, 메세지 반환도함.


        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}