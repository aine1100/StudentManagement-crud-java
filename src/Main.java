import java.awt.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Student> students=new ArrayList<Student>();

    public static List<Student>getAllStudents(){
        return students;
    }
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/studmanagement";
        String username = "root";
        String password = "";

        try {

            Connection con = DriverManager.getConnection(url, username, password);


            Statement conStat = con.createStatement();

            if (con != null) {
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

    public static void UserChoices(Statement conStat) {
        Scanner scanner = new Scanner(System.in);
        boolean continueChoices = true;

        while (continueChoices) {
            System.out.println("recent user now "+getAllStudents().size());
            System.out.println(getAllStudents());
            System.out.println("Dear user, welcome to the program: make your choice");
            System.out.println("1) Add new Student");
            System.out.println("2) Delete a student");
            System.out.println("3) Edit student");
            System.out.println("4) Show student");
            System.out.println("5) Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent(conStat);
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
                    continueChoices = false;
                    System.out.println("Thanks for using our program.");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public static void addStudent(Statement conStat) {

        Scanner scanner = new Scanner(System.in);



        System.out.println("Enter the student Name:");
        String studentName = scanner.nextLine();


        System.out.println("Enter the student Class:");
        String studentClass = scanner.nextLine();


        System.out.println("Enter the student Email:");
        String studentEmail = scanner.nextLine();


        System.out.println("Enter the student Age:");
        int age = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Enter the student date of birth (format: yyyy-MM-dd):");
        String Dob = scanner.nextLine();


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfBirth = LocalDate.parse(Dob, formatter);


        String userDate = dateOfBirth.toString();

        Student student=new Student(studentName,studentClass,age,studentEmail,userDate);


        String sql = "INSERT INTO students(studentName, studentClass, studentEmail, age, dateOfBirth) " +
                "VALUES('" + student.getStudentName() + "', '" + student.getStudentClass() + "', '" + student.getStudentEmail() + "', " + student.getAge() + ", '" + student.getDate() + "')";

        try {

            int insertStudent = conStat.executeUpdate(sql);

            if (insertStudent > 0) {
                System.out.println("A new student was added successfully.");
            }


            System.out.println(student.toString());
            students.add(student);

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void deleteStudent(Statement conStat) {
        Student student=new Student();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the student you want to delete:");
        String studentName = scanner.nextLine();
        student.setStudentName(studentName);

        String deleteQuery = "DELETE FROM students WHERE studentName= '" + student.getStudentName() + "'";

        try {
            conStat.executeUpdate(deleteQuery);
            System.out.println("Successfully deleted " + studentName + " from the database");
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void editStudent(Statement conStat) {
        Student student=new Student();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the student you want to edit:");
        String studentName = scanner.nextLine();
        System.out.println("Enter the student's new name:");
        String StudentName = scanner.nextLine();
        student.setStudentName(StudentName);
        System.out.println("Enter the student's new Class:");
        String StudentClass = scanner.nextLine();
        student.setStudentClass(StudentClass);
        System.out.println("Enter the student's new email:");
        String StudentEmail = scanner.nextLine();
        student.setStudentEmail(StudentEmail);
        System.out.println("Enter the student's new age:");
        int StudentAge = scanner.nextInt();
        student.setAge(StudentAge);

        String sql = "UPDATE students SET studentName='" + student.getStudentName() +
                "', studentClass='" + student.getStudentClass() +
                "', studentEmail='" + student.getStudentEmail() +
                "', age=" + student.getAge() +
                " WHERE studentName='" + studentName + "'";

        try {
            int editedRows = conStat.executeUpdate(sql);
            if (editedRows > 0) {
                System.out.println("The user was edited successfully");
                System.out.println(student.toString());
            } else {
                System.out.println("Failed to edit the user");
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void showStudent(Statement conStat) {
        Student student=new Student();
        String sql = "SELECT * FROM students";

        try {
            ResultSet rs = conStat.executeQuery(sql);
            while (rs.next()) {
                student.setStudentName(rs.getString("studentName"));
                student.setStudentEmail(rs.getString("studentEmail"));
                student.setStudentClass(rs.getString("studentClass"));
                student.setAge(rs.getInt("age"));
                student.setDate(rs.getString("dateOfBirth"));
                System.out.println(student.toString());
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
