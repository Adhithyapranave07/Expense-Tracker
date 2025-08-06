import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class ExpenseDAO {
    private final Connection conn;

    public ExpenseDAO() {
        conn = DBConnection.getConnection();
    }

    public void addExpense(Expense e ) {
        String query = "INSERT INTO expenses (category, amount, date) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, e.getCategory());
            stmt.setDouble(2, e.getAmount());
            stmt.setString(3, e.getDate());
            stmt.executeUpdate();
            System.out.println("✅ Expense added successfully!");
        } catch (SQLException o) {
            o.printStackTrace();
        }
    }

    public ArrayList<Expense> viewExpenses() {
        String query = "SELECT * FROM expenses";
        ArrayList<Expense> list = new ArrayList<>();

        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {


            while (rs.next()) {

                int id = rs.getInt("id");
                String category = rs.getString("category");
                double amount = rs.getDouble("amount");
                String date = rs.getString("date");
                Expense e1 = new Expense(id, category, amount, date);

                list.add(e1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void updateExpense(int id, String category, double amount, String date) {
        String query = "UPDATE expenses SET category = ?, amount = ?, date = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, category);
            stmt.setDouble(2, amount);
            stmt.setString(3, date);
            stmt.setInt(4, id);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("✅ Expense updated successfully!");
            } else {
                System.out.println("❌ Expense not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteExpense(int id) {
        String query = "DELETE FROM expenses WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("✅ Expense deleted successfully!");
            } else {
                System.out.println("❌ Expense not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
