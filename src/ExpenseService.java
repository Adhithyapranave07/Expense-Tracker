import java.util.List;

public class ExpenseService {
    private final ExpenseDAO expenseDAO;

    public ExpenseService() {
        this.expenseDAO = new ExpenseDAO();
    }

    public void addExpense(String category, double amount, String date) {
        Expense expense = new Expense(category, amount, date);
        expenseDAO.addExpense(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenseDAO.viewExpenses();
    }

    public void updateExpense(int id, String category, double amount, String date) {
        expenseDAO.updateExpense(id, category, amount, date);
    }

    public void deleteExpense(int id) {
        expenseDAO.deleteExpense(id);
    }
}