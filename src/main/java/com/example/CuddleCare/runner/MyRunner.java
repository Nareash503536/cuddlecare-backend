package com.example.CuddleCare.runner;

import com.example.CuddleCare.service.RoleService;
import com.example.CuddleCare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        createRoles();
        createUsers();
    }

    private void createUsers() {
        for (int i = 0; i < 10; i++) {
            userService.createUser("user" + i + "@gmail.com", "1234", "userFN" + i, "userLN" + i, "user" + i, "2015/01/01");
        }
    }

    private void createRoles() {
        Arrays.asList("Parents",
                "GuestUser",
                "Caregiver",
                "ContentManager",
                "Admin").forEach(roleName -> {
            roleService.createRole(roleName);
        });
    }


}
