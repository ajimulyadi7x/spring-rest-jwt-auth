package com.cdc2023.springrestjwtauth.socialmedia.repository;

import com.cdc2023.springrestjwtauth.socialmedia.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
