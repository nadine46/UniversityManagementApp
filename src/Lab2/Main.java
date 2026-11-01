package Lab2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/University_db",
                "postgres",
                "ikofi123"
        );

        StudentDAO studentDAO = new StudentDAO(con);
        CourseDAO courseDAO = new CourseDAO(con);
        EnrollmentDAO enrollmentDAO = new EnrollmentDAO(con);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== University Management System ===");
            System.out.println("1. View Students");
            System.out.println("2. View Courses");
            System.out.println("3. View Student Enrollments");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    studentDAO.getStudents();
                    break;
                case 2:
                    courseDAO.getCourses();
                    break;
                case 3:
                    enrollmentDAO.getStudentCourses();
                    break;
                case 4:
                    System.out.println("Exiting University Management System.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        scanner.close();
        con.close();
    }
}