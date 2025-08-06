import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseService expenseService = new ExpenseService();

        while (true) {
            System.out.println("\n📌 Expense Tracker Menu");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Update Expense");
            System.out.println("4. Delete Expense");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    expenseService.addExpense(category, amount, date);
                    break;

                case 2:
                    System.out.println("\n📜 Expenses List:");
                    System.out.println("ID | Category | Amount | Date");
                    System.out.println("----------------------------------");
                    List<Expense> expenses = expenseService.getAllExpenses();
                    for (Expense e : expenses) {
                        System.out.printf("%d | %s | %.2f | %s\n", e.getId(), e.getCategory(), e.getAmount(), e.getDate());
                    }
                    break;

                case 3:
                    System.out.print("Enter expense ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new category: ");
                    String newCategory = scanner.nextLine();
                    System.out.print("Enter new amount: ");
                    double newAmount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter new date (YYYY-MM-DD): ");
                    String newDate = scanner.nextLine();
                    expenseService.updateExpense(updateId, newCategory, newAmount, newDate);
                    break;

                case 4:
                    System.out.print("Enter expense ID to delete: ");
                    int deleteId = scanner.nextInt();
                    expenseService.deleteExpense(deleteId);
                    break;

                case 5:
                    System.out.println("🔴 Exiting Expense Tracker...");
                    scanner.close();
                    return;

                default:
                    System.out.println("❌ Invalid choice! Please try again.");
            }
        }
    }
}