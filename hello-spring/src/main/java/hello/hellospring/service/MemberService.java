package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Service // 스프링이 컨테이너에 서비스로 등록함.
@Transactional // jpa쓰려면 서비스에 트랙져셔널이 필요함. 저장 변경 시 ㅇㅇ
public class MemberService {
    private final MemberRepository memberRepository;

//    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //    회원가입
    public Long join (Member member){
//        중복회원 nope!
//        직접 안꺼내고 optional로 감싸야지 메소드로 그렇고 더 편함 orElseGet 이런 것도 있음.
        isExistsName(member);
        memberRepository.save(member);
        return member.getId();
    }

//  전체회원조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    private void isExistsName(Member member) {
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m ->{
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

}
