// new interface ExpenseService

package com.example.CuddleCare.service.Impl;
import com.example.CuddleCare.dao.BudgetDao;
import com.example.CuddleCare.dao.ExpenseDao;
import com.example.CuddleCare.dto.BudgetDTO;
import com.example.CuddleCare.dto.ExpenseDTO;
import com.example.CuddleCare.entity.Budget;
import com.example.CuddleCare.mapper.BudgetMapper;
import com.example.CuddleCare.service.BudgetService;
import com.example.CuddleCare.service.ExpenseService;
import org.springframework.stereotype.Service;
import com.example.CuddleCare.mapper.ExpenseMapper;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import com.example.CuddleCare.entity.Expense;
import java.time.LocalDate;
import java.text.DateFormat;
import java.util.List;
import java.util.Date;
import java.time.Month;
import java.time.format.DateTimeFormatter;
@Service
@Transactional
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseMapper expenseMapper;
    private BudgetMapper budgetMapper;
    private ExpenseDao expenseDao;
    private BudgetDao budgetDao;
    private BudgetDTO budgetDTO;


    public ExpenseServiceImpl(ExpenseDao expenseDao, ExpenseMapper Expensemapper, BudgetDao BudgetDao, BudgetMapper budgetMapper) {
        this.expenseDao = expenseDao;
        this.expenseMapper = Expensemapper;
        this.budgetDao = BudgetDao;
        this.budgetMapper = budgetMapper;
    }


    @Override
    public ExpenseDTO createExpense(ExpenseDTO expenseDTO) {
        Expense expense = expenseMapper.FromExpenseDto(expenseDTO);
        Expense savedExpense = expenseDao.save(expense);
        return expenseMapper.FromExpense(savedExpense);

    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseDao.findAll();
    }

//    @Override
//    public  Double getTotalIncome() {
//        return expenseDao.TotalIncome();
//    }

    @Override
    public  Double getTotalExpense() {
        Double total_expense = 0.0;
        LocalDate currentDate = LocalDate.now();
        Month currentMonth = currentDate.getMonth();
        int monthValue = currentMonth.getValue();
        int year = currentDate.getYear();

        List<Expense> expenses = expenseDao.findAll();
        if(expenses != null && expenses.size() >0){

                for(Expense expense : expenses){
                    Date expenseDate = expense.getDate();
                    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
                    LocalDate expenselocalDate = LocalDate.parse(expenseDate.toString(),inputFormatter);

                    System.out.println("current data of month and year: " + expenselocalDate.getMonthValue()+" "+expenselocalDate.getYear()+" "+monthValue+" "+year);

                    if ((expenselocalDate.getMonthValue() == monthValue) && (expenselocalDate.getYear() == year)) {
                        total_expense = total_expense + expense.getAmount();

                    }

                }


            }
        return total_expense;
        }






//    public  Double getTotalExpense() {
//       Double total_expense = 0.0;
//
//        List<Expense> expenses = expenseDao.findAll();
//        if(expenses != null && expenses.size() >0){
//            Budget budgets=  budgetDao.TotalBudget().orElse(null);
//
//            Date lastDate = budgetDao.getLastDate();
//
//            if(budgets != null){
//               BudgetDTO budget = budgetMapper.FromBudget(budgets);
//               for(Expense expense : expenses){
//                   Date expenseDate = expense.getDate();
//                   Date startDate = budget.getStartdate();
//                   Date endDate = budget.getEnddate();
//
//                   if ((expenseDate.after(startDate) || expenseDate.equals(startDate)) && (expenseDate.before(endDate) || expenseDate.equals(endDate))) {
//                       total_expense = total_expense + expense.getAmount();
//
//                   }
//
//               }
//
//
//           }
//           else{
//               for(Expense expense : expenses){
//                   Date expenseDate = expense.getDate();
//                   if(expenseDate.after(lastDate)){
//                       total_expense = total_expense + expense.getAmount();
//                   }
//
//               }
//
//
//           }
//        }
//        return total_expense;
//
//
//
//
//    }
    @Override
    public Date getFirstdate() {
        return expenseDao.getfirstDate();
    }
    @Override
    public void deleteExpense(Long expenseID) {
        expenseDao.deleteById(expenseID);
    }

    @Override
    public ExpenseDTO updateExpense(ExpenseDTO expenseDTO){
            Expense expense = expenseMapper.FromExpenseDto(expenseDTO);
            expense.setExpenseID(expenseDTO.getExpenseID());
            Expense updatedexpense= expenseDao.save(expense);
            ExpenseDTO savedExpense = expenseMapper.FromExpense(updatedexpense);
            savedExpense.setExpenseID(expenseDTO.getExpenseID());
            return savedExpense;
    }
}



