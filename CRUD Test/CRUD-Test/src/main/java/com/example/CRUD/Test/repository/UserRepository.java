package com.example.CRUD.Test.repository;

import com.example.CRUD.Test.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
@Repository

따로 쿼리문 작성없이 생성, 조회, 업데이트, 삭제(CRUD)를 할 수 있게 기능을 제공해줌
제너릭 타입으로는 첫번째부터, <Entity, PrimaryKey의 타입>을 넣는다

 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
