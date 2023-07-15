package com.example.CuddleCare.service.Impl;

import com.example.CuddleCare.dao.RoleDao;
import com.example.CuddleCare.dao.UserDao;
import com.example.CuddleCare.entity.Role;
import com.example.CuddleCare.entity.User;
import com.example.CuddleCare.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private PasswordEncoder passwordEncoder;
    private UserDao userDao;

    private RoleDao roleDao;

    public UserServiceImpl(UserDao userDao, RoleDao roleDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User loadUserByUsername(String Username) {
        return userDao.findByUserName(Username);
    }

    @Override
    public User loadUSerUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User createUser(String username, String password, String email, String nic, String address, String dob) {
        String encodedPassword = this.passwordEncoder.encode(password);
        return userDao.save(new User(username, encodedPassword, email, nic, address, dob));
    }

    @Override
    public void AssignRoleToUser(String email, String roleName) {
        User user = userDao.findByEmail(email);
        Role role = roleDao.findByRoleName(roleName);
        user.getRoles().add(role);
    }
}