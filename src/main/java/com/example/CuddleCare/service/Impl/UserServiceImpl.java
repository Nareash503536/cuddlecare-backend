package com.example.CuddleCare.service.Impl;

import com.example.CuddleCare.dao.RoleDao;
import com.example.CuddleCare.dao.UserDao;
import com.example.CuddleCare.dto.UserDTO;
import com.example.CuddleCare.entity.Role;
import com.example.CuddleCare.entity.User;
import com.example.CuddleCare.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
        return userDao.findByUsername(Username);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User loadUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User createUser(UserDTO userDTO) {
        String encodedPassword = this.passwordEncoder.encode(userDTO.getPassword());
        return userDao.save(new User(
                userDTO.getUsername(),
                encodedPassword,
                userDTO.getEmail(),
                userDTO.getDob(),
                userDTO.getContactNumber(),
                userDTO.getGender(),
                userDTO.getRelationship()
        ));
    }

    @Override
    public void AssignRoleToUser(String email, String roleName) {
        User user = loadUserByEmail(email);
        Role role = roleDao.findByRoleName(roleName);
        user.assignRoleToUser(role);
    }

    @Override
    public void authenticateUser(String email) {
        // TODO Auto-generated method stub
        User user = loadUserByEmail(email);
        user.setAuthenticated(true);
    }

    @Override
    public User updateUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User updateUserByAttribute(String email, String attribute, String value) {
        User user = loadUserByEmail(email);
        if(attribute.equals("username"))
            user.setUsername(value);
        else if(attribute.equals("email"))
            user.setEmail(value);
        else if(attribute.equals("dob"))
            user.setDob(value);
        else if(attribute.equals("contactNumber"))
            user.setContactNumber(value);
        else if(attribute.equals("gender"))
            user.setGender(value);
        return userDao.save(user);
    }


}