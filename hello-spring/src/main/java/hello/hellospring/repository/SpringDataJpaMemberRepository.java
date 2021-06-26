package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// 스프링 데이터 jpa가 구현체를 자동으로 만들어서 빈에 자동으로 등록함.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

//    기본적인 메소드 crud를 제공함. 그래서 우리가 뭐 save 이런게 다 제공이 됨. 이름을 맞춰놓으면
//    그래도 고도화된 메소드는 어려움 그래도. 어느정도 기틀이 잡혀있으면 제공함

//    == select m from Member m where m.name = ? 와 같음 findBy???? 이런거 ㅇㅇ
    @Override
    Optional<Member> findByName(String name);
}
