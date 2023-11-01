package com.example.CuddleCare.runner;

import com.example.CuddleCare.dto.*;
import com.example.CuddleCare.entity.User;
import com.example.CuddleCare.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private BudgetService budgetService;

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private SymptomService symptomService;

    @Autowired
    private ParentService parentService;

    @Autowired
    private BabyService babyService;

    @Autowired
    private VaccinationService vaccinationService;

    @Autowired
    private CaregiverService caregiverService;

    @Override
    public void run(String... args) throws Exception {
//         createRoles();
//         createUsers();
        // assignRoles();
        // createExpense();
        // createBudget();
        // createSymptom();
        // createBaby();

//        createVaccination();

//        createParentUser();

//        Baby baby = babyService.loadBabyById(20L);
//        Caregiver caregiver = caregiverService.loadCaregiverById(1L);
//        baby.setCaregiver(caregiver);
//        caregiver.getBabies().add(baby);
//        caregiverService.updateCaregiver(caregiver);
//        babyService.updateBaby(baby);
    }

    public void createVaccination(){
        String[] names = new String[]{
                "BCG - Dose 1",
                "DTwP - Dose 1",
                "Hib - Dose 1",
                "HepB - Dose 3",
                "OPV - Dose 1",
                "DTwP - Dose 2",
                "Hib - Dose 2",
                "HepB - Dose 1",
                "OPV - Dose 2",
                "DTwP - Dose 3",
                "Hib - Dose 3",
                "HepB - Dose 2",
                "OPV - Dose 3",
                "Vitamin A - Dose 1",
                "JE - Dose 1",
                "MMR - Dose 1",
                "Vitamin A - Dose 2",
                "OPV - Dose 4",
                "Vitamin A - Dose 3",
                "DTwP - Dose 4",
                "Vitamin A - Dose 4",
                "Vitamin A - Dose 5",
                "MMR - Dose 2",
                "Vitamin A - Dose 6",
                "OPV - Dose 5",
                "DT - Dose 1"
        };
        String[] categories = new String[]{
                "",
                "Diphtheria, Tetanus Vaccine",
                "Haeomophilus Influenzae Type B",
                "Hepatitis B",
                "Oral Polio Vaccine",
                "Diphtheria, Tetanus Vaccine",
                "Haeomophilus Influenzae Type B",
                "Hepatitis B",
                "Oral Polio Vaccine",
                "Diphtheria, Tetanus Vaccine",
                "Haeomophilus Influenzae Type B",
                "Hepatitis B",
                "Oral Polio Vaccine",
                "Vitamin A supplementation",
                "",
                "Measles, Mumps, Rubella Vaccine",
                "Vitamin A supplementation",
                "Oral Polio Vaccine",
                "Vitamin A supplementation",
                "Diphtheria, Tetanus Vaccine",
                "Vitamin A supplementation",
                "Vitamin A supplementation",
                "Measles, Mumps, Rubella Vaccine",
                "Vitamin A supplementation",
                "Oral Polio Vaccine",
                "Tenanus and Diphtheria toxoid",
        };
        int[] months = new int[]{
                0,
                2,
                2,
                2,
                2,
                4,
                4,
                4,
                4,
                6,
                6,
                6,
                6,
                6,
                9,
                12,
                12,
                18,
                18,
                18,
                24,
                30,
                36,
                36,
                60,
                60
        };
        for (int i = 0; i < names.length; i++) {
            VaccinationDTO vaccinationDTO = new VaccinationDTO();
            vaccinationDTO.setName(names[i]);
            vaccinationDTO.setCategory(categories[i]);
            vaccinationDTO.setMonths(months[i]);
            vaccinationService.createVaccination(vaccinationDTO);
        }
    }

    private void createBaby() {
        for (int i = 0; i < 5; i++) {
            babyService.createBaby(
                    "male",
                    "01/01/2000",
                    "Baby" + i);
        }
    }

    private void createSymptom() {
        symptomService.createSymptom("Fever");
        symptomService.createSymptom("No negative symptoms");
        symptomService.createSymptom("General Fussiness");
        symptomService.createSymptom("Cough");
        symptomService.createSymptom("Vomiting");
        symptomService.createSymptom("Low energy");
        symptomService.createSymptom("Runny nose");
        symptomService.createSymptom("Abnormal breathing");
        symptomService.createSymptom("Spit-up");
        symptomService.createSymptom("No appetite");
        symptomService.createSymptom("Rash");
    }

    private void createExpense() {
        ExpenseDTO expenseDTO = new ExpenseDTO();
        expenseDTO.setAmount(700.0);
        expenseDTO.setExpenseName("Food");
        expenseDTO.setNotes("Pizza at Pizza hut");

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = sdf.parse("2023/07/31");
            expenseDTO.setDate(date);
        }catch (ParseException e){
            e.printStackTrace();
            return;
        }

        expenseService.createExpense(expenseDTO);

        ExpenseDTO expenseDTO2 = new ExpenseDTO();
        expenseDTO2.setAmount(300.0);
        expenseDTO2.setExpenseName("Food");
        expenseDTO2.setNotes("biriyani");

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = sdf.parse("2023/08/01");
            expenseDTO2.setDate(date);
        }catch (ParseException e){
            e.printStackTrace();
            return;
        }
        expenseService.createExpense(expenseDTO2);
//        assignRoles();
        // createParentUser();
    }

    private void createParentUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("Nareash");
        userDTO.setEmail("user1@gmail.com");
        userDTO.setPassword("User__123");
        userDTO.setDob("15/01/2001");
        userDTO.setContactNumber("0987654321");
        userDTO.setGender("male");
        ParentDTO parentDTO = new ParentDTO();
        parentDTO.setUser(userDTO);
        parentService.createParentDTO(parentDTO);
    }
    private void createBudget() {
        BudgetDTO budgetDTO = new BudgetDTO();
        budgetDTO.setAmount(1000.0);
        budgetDTO.setBudgetName("1st week budget");


        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = sdf.parse("2023/07/28");
            Date datenew = sdf.parse("2023/07/29");
            budgetDTO.setStartdate(date);
            budgetDTO.setEnddate(datenew);
        }catch (ParseException e){
            e.printStackTrace();
            return;
        }

        budgetService.createBudget(budgetDTO);

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
                userService.AssignRoleToUser(user.getEmail(), "Caregiver");
            else if(i[0] % 5 == 0) {
                userService.AssignRoleToUser(user.getEmail(), "GuestUser");
            }
            i[0]++;
        }
        );
    }

    private void createUsers() {
        for (int i = 0; i < 10; i++) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUsername("user" + i + "@gmail.com");
            userDTO.setEmail("user" + i + "@gmail.com");
            userDTO.setPassword("User" + i + "__123");
            userDTO.setDob("01/01/2000");
            userDTO.setContactNumber("1234567890");
            userDTO.setGender("Female");
            userService.createUser(userDTO);
        }
    }

    private void createRoles() {
        Arrays.asList("Parent",
                "GuestUser",
                "Caregiver",
                "ContentManager",
                "Admin").forEach(roleName -> {
            roleService.createRole(roleName);
        });
    }


}
