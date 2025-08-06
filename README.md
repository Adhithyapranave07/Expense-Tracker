


# 💸 Daily Expense Tracker (Java + MySQL)

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.oracle.com/java/)
[![MySQL](https://img.shields.io/badge/MySQL-00758F?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/) 
[![Made with Love](https://img.shields.io/badge/Made%20with-%E2%9D%A4-red?style=for-the-badge)](https://github.com/Adhithyapranave07)

A **command-line application** to manage your daily expenses with a clean menu-based interface. Easily **add**, **view**, **update**, and **delete** expenses with MySQL database persistence.

---

## 📸 Demo

> Here's how the CLI interface looks while running: 

---

## 🔥 Features

- ✅ Add new expense entries
- 📋 View all recorded expenses
- ✏️ Update existing entries by ID
- 🗑️ Delete expenses by ID
- 💾 Persistent MySQL database integration
- 📆 Store date of each transaction

---

## 🧰 Tech Stack

| Component   | Tech                          |
|------------|-------------------------------|
| Language    | Java                          |
| Database    | MySQL                         |
| DB Access   | JDBC                          |
| IDE         | IntelliJ / Eclipse / VS Code |

---

## ⚙️ Setup Instructions

### 📌 Prerequisites

- Java JDK 8 or higher
- MySQL installed and running
- MySQL Workbench (optional)
- IDE (like IntelliJ or Eclipse)

---

### 📂 Clone the Repository


git clone https://github.com/Adhithyapranave07/Expense-Tracker.git
cd Expense-Tracker
🛠️ Database Setup
Run this in your MySQL terminal or Workbench:


CREATE DATABASE IF NOT EXISTS expense_tracker;

USE expense_tracker;

CREATE TABLE IF NOT EXISTS expenses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    category VARCHAR(255) NOT NULL,
    amount DOUBLE NOT NULL,
    date DATE NOT NULL
);
✏️ Update Database Config
In DBConnection.java, set your local database credentials:

java

private static final String URL = "jdbc:mysql://localhost:3306/expense_tracker";
private static final String USER = "root";
private static final String PASSWORD = ""; // Your MySQL password
▶️ Run the Application
Use your IDE to run Main.java or compile via terminal:

javac *.java
java Main
You’ll see:

 Expense Tracker Menu
1. Add Expense
2. View Expenses
3. Update Expense
4. Delete Expense
5. Exit

📁 Project Structure

Expense-Tracker/
│
├── DBConnection.java       # MySQL connection
├── Expense.java            # Expense model class
├── ExpenseDAO.java         # DB operations (CRUD)
├── ExpenseService.java     # Service layer
└── Main.java               # CLI interface

📊 Sample Output
ID | Category | Amount | Date
----------------------------------
1  | Food     | 150.00 | 2025-08-01
2  | Travel   | 80.50  | 2025-08-02

🚀 Future Enhancements
GUI using JavaFX or Swing
Export to Excel or PDF
Search & filter by date or category
Charts & statistics
User authentication system

🙋‍♂️ Author
Adhithya Pranave
📧 Connect on LinkedIn
 

⭐ Star This Repository
If you found this helpful or learned something, consider giving it a ⭐ on GitHub — it motivates me to build more.
