package com.example.CuddleCare.dao;

import com.example.CuddleCare.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
    Role findByRoleName(String RoleName);
}
