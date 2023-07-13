package com.example.CuddleCare.service.Impl;

import com.example.CuddleCare.dao.RoleDao;
import com.example.CuddleCare.dao.UserDao;
import com.example.CuddleCare.entity.Role;
import com.example.CuddleCare.entity.User;
import com.example.CuddleCare.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    private RoleDao roleDao;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
//        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User loadUserByUsername(String Username) {
        return userDao.findByUserName(Username);
    }

    @Override
    public User createUser(String username, String password, String email, String nic, String address, Date dob) {
        return userDao.save(new User(username, password, email, nic, address, dob));
    }


    @Override
    public void AssignRoleToUser(String email, String roleName) {
        User user = userDao.findByEmail(email);
        Role role = roleDao.findByRoleName(roleName);
        user.getRoles().add(role);
    }
}