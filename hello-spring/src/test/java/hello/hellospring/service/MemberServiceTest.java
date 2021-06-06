package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemoryMemberRepository memberRepository;
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
//        멤버서비스에선 멤버리포지토리를 외부에서 넣어주지! 이걸 DI! 의존성주입
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }


    @Test
    void join() {
        //given
        // 이런 상황이 주어졌을때
        Member member = new Member();
        member.setName("hello");


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
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

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