package com.cdc2023.springrestjwtauth.socialmedia.repository;

import com.cdc2023.springrestjwtauth.socialmedia.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testInsert() {
        User user = new User();
        user.setName("Aji Mulyadi");
        user.setDob(LocalDate.of(1990, 5, 15));

        userRepository.save(user);

        assertNotNull(user.getId());
    }

    @Test
    void testUpdate() {
        User user = userRepository.findById("bf889935-fc9d-490f-80c1-b239dea7d9ec").orElse(null);
        assertNotNull(user);

        String newUserName = "Aji Atin Mulyadi";
        LocalDate newDob = LocalDate.of(2000, 10, 15);

        user.setName(newUserName);
        user.setDob(newDob);

        User updatedUser = userRepository.save(user);

        assertEquals(newUserName, updatedUser.getName());
        assertEquals(newDob.getMonth().getValue(), updatedUser.getDob().getMonth().getValue());
    }

}