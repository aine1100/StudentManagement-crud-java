import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studManagement";
        String username = "root";
        String password = "";

        try {
            // Establishing the connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Creating the statement
            Statement conStat = con.createStatement();

            if (con != null) {  // Checking if connection is not null
                System.out.println("You have successfully connected to the database");
            } else {
                System.out.println("Failed to connect to the database");
            }

            // Call user choices method
            UserChoices(conStat); // Pass the statement object here

        } catch (SQLException e) {
            // Handle the exception
            System.out.println("SQLException: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void UserChoices(Statement conStat) {  // Pass Statement to use it in methods
        Scanner scanner = new Scanner(System.in);
        boolean continueChoices = true; // Loop control variable

        while (continueChoices) {
            System.out.println("Dear user, welcome to the program: make your choice");
            System.out.println("1) Add new Student");
            System.out.println("2) Delete a student");
            System.out.println("3) Edit student");
            System.out.println("4) Show student");
            System.out.println("5) Exit"); // Exit option

            int choice = scanner.nextInt();  // Initialize choice variable

            switch (choice) {
                case 1:
                    addStudent(conStat);  // No return needed
                    break;
                case 2:
                    deleteStudent(conStat);
                    break;
                case 3:
                    editStudent(conStat);
                    break;
                case 4:
                    showStudent(conStat);
                    break;
                case 5:
                    continueChoices = false; // Set to false to exit the loop
                    System.out.println("Thanks for using our program.");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public static void addStudent(Statement conStat) {
        Scanner scanner = new Scanner(System.in);  // Corrected System.in

        // Prompting the user for input
        System.out.println("Enter the student Name:");
        String studentName = scanner.nextLine();

        System.out.println("Enter the student Class:");
        String studentClass = scanner.nextLine();

        System.out.println("Enter the student Email:");
        String studentEmail = scanner.nextLine();

        System.out.println("Enter the student Age:");
        int age = scanner.nextInt();

        // Correct SQL INSERT statement
        String sql = "INSERT INTO students(studentName, studentClass, studentEmail, age) " +
                "VALUES('" + studentName + "', '" + studentClass + "', '" + studentEmail + "', " + age + ")";

        try {
            // Use executeUpdate() for INSERT, UPDATE, DELETE
            int insertStudent = conStat.executeUpdate(sql);

            if (insertStudent > 0) {
                System.out.println("A new student was added successfully.");
            }

            // Print out the student details
            System.out.println("Student Name: " + studentName);
            System.out.println("Student Class: " + studentClass);
            System.out.println("Age: " + age);
            System.out.println("Email: " + studentEmail);

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void deleteStudent(Statement conStat) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the student you want to delete:");
        String studentName = scanner.nextLine();
        String deleteQuery = "DELETE FROM students WHERE studentName= '" + studentName + "'";

        try {
            conStat.executeUpdate(deleteQuery);
            System.out.println("Successfully deleted " + studentName + " from the database");
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void editStudent(Statement conStat) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the student you want to edit:");
        String studentName = scanner.nextLine();
        System.out.println("Enter the student's new name:");
        String StudentName = scanner.nextLine();
        System.out.println("Enter the student's new Class:");
        String StudentClass = scanner.nextLine();
        System.out.println("Enter the student's new email:");
        String StudentEmail = scanner.nextLine();
        System.out.println("Enter the student's new age:");
        int StudentAge = scanner.nextInt();

        String sql = "UPDATE students SET studentName='" + StudentName +
                "', studentClass='" + StudentClass +
                "', studentEmail='" + StudentEmail +
                "', age=" + StudentAge +
                " WHERE studentName='" + studentName + "'";

        try {
            int editedRows = conStat.executeUpdate(sql);
            if (editedRows > 0) {
                System.out.println("The user was edited successfully");
                System.out.println("Student Name: " + StudentName);
                System.out.println("Student Class: " + StudentClass);
                System.out.println("Age: " + StudentAge);
                System.out.println("Email: " + StudentEmail);
            } else {
                System.out.println("Failed to edit the user");
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void showStudent(Statement conStat) {
        String sql = "SELECT * FROM students";

        try {
            ResultSet rs = conStat.executeQuery(sql);
            while (rs.next()) {
                String StudentName = rs.getString("studentName");
                String StudentEmail = rs.getString("studentEmail");
                String StudentClass = rs.getString("studentClass");
                int StudentAge = rs.getInt("age");
                System.out.println("Student Name: " + StudentName);
                System.out.println("Student Class: " + StudentClass);
                System.out.println("Age: " + StudentAge);
                System.out.println("Email: " + StudentEmail);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
