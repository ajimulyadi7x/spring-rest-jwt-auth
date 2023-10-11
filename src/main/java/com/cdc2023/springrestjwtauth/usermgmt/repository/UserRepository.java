package com.cdc2023.springrestjwtauth.usermgmt.repository;

import com.cdc2023.springrestjwtauth.usermgmt.entiity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByEmailAndRecordStatusId(String email, int recordStatusId);
}
