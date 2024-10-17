import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;  // Corrected to use PreparedStatement
import java.sql.SQLException;
import java.sql.Statement;


public class FileReading {
    public static void main(String[] args){

        String url = "jdbc:mysql://localhost:3306/StudentsFile";
        String username = "root";
        String password = "";

        File file = new File("C:\\Users\\user\\Downloads\\students.csv");

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement conStat = con.createStatement();
            if (con != null) {
                System.out.println("Connected to database");




                try {
                    BufferedReader readFile = new BufferedReader(new FileReader(file));
                    String singleStudent;
                    singleStudent = readFile.readLine();  // Skip header line if needed

                    SimpleDateFormat inputDateFormat = new SimpleDateFormat("M/d/yyyy");  // Input format from CSV
                    SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd"); // MySQL format

                    while ((singleStudent = readFile.readLine()) != null) {
                        String data[] = singleStudent.split(",");

                        // Assuming data is: name, class, age, dob
                        Student student = new Student();
                        student.setStudentName(data[0]);
                        student.setAge(Integer.parseInt(data[1]));  // Parsing age to integer
                        student.setStudentClass(data[2]);
                        student.setStudentEmail(data[3]);

                        // Convert date from MM/DD/YYYY to YYYY-MM-DD
                        Date dob = inputDateFormat.parse(data[3]);  // Parse the date
                        String formattedDate = outputDateFormat.format(dob);  // Format to YYYY-MM-DD
                        student.setDate(formattedDate);

                        // Set the values for the PreparedStatement
                        String sql = "INSERT INTO students (name, class, age, dob,email) " +
                                "VALUES('" + student.getStudentName() + "', '" + student.getStudentClass() + "', '" + student.getAge() + "', '" + student.getDate() + "', '" + student.getStudentEmail() + "')";
                        // Execute the insert
                        Statement insertStatement= con.prepareStatement(sql);

                        insertStatement.executeUpdate(sql);

                        System.out.println(student.toString());
                    }
                    readFile.close();

                } catch (ParseException e) {
                    System.out.println("Error in parsing the date");
                    e.printStackTrace();
                } catch (Exception e) {
                    System.out.println("Error in reading the file");
                    e.printStackTrace();
                }

            } else {
                System.out.println("Failed to connect to the database");
            }
        } catch (SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
        }
    }
}
