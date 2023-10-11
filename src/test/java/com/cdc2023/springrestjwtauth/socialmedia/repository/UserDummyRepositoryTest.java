package com.cdc2023.springrestjwtauth.socialmedia.repository;

import com.cdc2023.springrestjwtauth.socialmedia.entity.UserDummy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDummyRepositoryTest {

    @Autowired
    private UserDummyRepository userDummyRepository;

    @Test
    void testInsert() {
        UserDummy userDummy = new UserDummy();
        userDummy.setName("Aji Mulyadi");
        userDummy.setDob(LocalDate.of(1990, 5, 15));

        userDummyRepository.save(userDummy);

        assertNotNull(userDummy.getId());
    }

    @Test
    void testUpdate() {
        UserDummy userDummy = userDummyRepository.findById("9852016e-f522-4a0f-a9be-0a51debe504c").orElse(null);
        assertNotNull(userDummy);

        String newUserName = "Aji Atin Mulyadi";
        LocalDate newDob = LocalDate.of(2000, 10, 15);

        userDummy.setName(newUserName);
        userDummy.setDob(newDob);

        UserDummy updatedUserDummy = userDummyRepository.save(userDummy);

        assertEquals(newUserName, updatedUserDummy.getName());
        assertEquals(newDob.getMonth().getValue(), updatedUserDummy.getDob().getMonth().getValue());
    }

}