package com.example.CRUD.Test;

import com.example.CRUD.Test.domain.User;
import com.example.CRUD.Test.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class CrudTestApplicationTests{

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

}
