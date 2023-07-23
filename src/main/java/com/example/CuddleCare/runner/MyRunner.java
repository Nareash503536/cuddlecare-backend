package com.example.CuddleCare.runner;



import com.example.CuddleCare.entity.User;
import com.example.CuddleCare.service.ExpenseService;
import com.example.CuddleCare.service.RoleService;
import com.example.CuddleCare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private ExpenseService expenseService;
    @Override
    public void run(String... args) throws Exception {
        createRoles();
        createUsers();
        assignRoles();
        createExpense();
    }

    private void createExpense() {
        expenseService.createExpense("Expense 1", "Expense 1 notes", 100.0);
        expenseService.createExpense("Expense 2", "Expense 2 notes", 200.0);
    }

    private void assignRoles() {
        List<User> allUsers = userService.getAllUsers();
        final int[] i = {1};
        allUsers.forEach(user -> {
            if(i[0] % 5 == 1)
                userService.AssignRoleToUser(user.getEmail(), "Admin");
            else if(i[0] % 5 == 2)
                userService.AssignRoleToUser(user.getEmail(), "Parent");
            else if(i[0] % 5 == 3)
                userService.AssignRoleToUser(user.getEmail(), "ContentManager");
            else if(i[0] % 5 == 4)
                userService.AssignRoleToUser(user.getEmail(), "CareGiver");
            else if(i[0] % 5 == 0) {
                userService.AssignRoleToUser(user.getEmail(), "GuestUser");
            }
            i[0]++;
        }
        );
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
