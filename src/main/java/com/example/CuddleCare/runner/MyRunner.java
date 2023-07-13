package com.example.CuddleCare.runner;

import com.example.CuddleCare.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private RoleService roleService;

    @Override
    public void run(String... args) throws Exception {
        createRoles();
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
