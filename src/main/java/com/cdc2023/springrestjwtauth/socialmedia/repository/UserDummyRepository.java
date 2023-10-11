package com.cdc2023.springrestjwtauth.socialmedia.repository;

import com.cdc2023.springrestjwtauth.socialmedia.entity.UserDummy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDummyRepository extends JpaRepository<UserDummy, String> {
}
