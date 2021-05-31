package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); // null처리를 위해 optional! java8
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
