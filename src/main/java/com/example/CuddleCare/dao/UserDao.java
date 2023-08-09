package com.example.CuddleCare.dao;//new class UserDao

import com.example.CuddleCare.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findByUsername(String username);
}

