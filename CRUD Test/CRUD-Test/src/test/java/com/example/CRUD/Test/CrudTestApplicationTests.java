package com.example.CRUD.Test;

import com.example.CRUD.Test.domain.User;
import com.example.CRUD.Test.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@Slf4j
class CrudTestApplicationTests{

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        User user = User.builder()
                .account("Test User 03")
                .email("testuser03@google.com")
                .phoneNumber("010-1234-5678")
                .createdAt(LocalDateTime.now())
                .createdBy("admin")
                .build();

        System.out.println(user.toString());
        User newUser = userRepository.save(user);
        System.out.println(newUser.toString());

    }

}
