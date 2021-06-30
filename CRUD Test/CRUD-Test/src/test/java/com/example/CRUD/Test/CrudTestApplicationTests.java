package com.example.CRUD.Test;

import com.example.CRUD.Test.domain.User;
import com.example.CRUD.Test.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@SpringBootTest
@Transactional
class CrudTestApplicationTests {

    //    @Autowired
    private UserRepository userRepository;

    @Autowired
    public CrudTestApplicationTests(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    public void create() {
        User user = User.builder()
                .account("Test User 03")
                .email("testuser03@google.com")
                .phoneNumber("010-1234-5678")
                .createdBy("admin")
                .build();

        System.out.println(user.toString());
        User newUser = userRepository.save(user);
        System.out.println(newUser.toString());

    }

    @Test
    public void read() {
        Optional<User> user = userRepository.findById(2L);
        user.ifPresent(selectUser -> { // ifPresent: 값이 있다면, 가져옴
            log.info(selectUser.toString());
        });
    }

    @Test
    public void update() {
        Optional<User> user = userRepository.findById(2L);
        user.ifPresent(selectUser -> {
            User newUser = User.builder()
                    .id(selectUser.getId())
                    .account(selectUser.getAccount())
                    .phoneNumber(selectUser.getPhoneNumber())
                    .email("updatedEmail@google.com")
                    .createdBy(selectUser.getCreatedBy())
                    .updatedAt(LocalDateTime.now())
                    .updatedBy("TestUser02")
                    .build();
            userRepository.save(newUser);
            log.info(newUser.toString());

        });
    }

    @Test
    public void delete() {
        Optional<User> user = userRepository.findById(1L);
        // User가 있어야 함
        Assertions.assertTrue(user.isPresent());
        // 있다면 삭제
        user.ifPresent(selectUser -> {
            userRepository.deleteById(selectUser.getId());
        });
        // 지워졌는지 확인
        Optional<User> deletedUser = userRepository.findById(1L);
        Assertions.assertFalse(deletedUser.isPresent());
    }


}
