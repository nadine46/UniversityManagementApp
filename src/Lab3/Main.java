package Lab3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import Lab2.StudentDAO;
import Lab2.CourseDAO;
import Lab2.EnrollmentDAO;

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
        System.out.println("Console input is ready.");

        int choice;

        do {
            System.out.println("\n=== University Management System ===");
            System.out.println("1. View Students");
            System.out.println("2. Add Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Add Course");
            System.out.println("5. View Courses");
            System.out.println("6. Remove Course");
            System.out.println("7. Enroll Student in Course");
            System.out.println("8. View Student Enrollments");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    studentDAO.getStudents();
                    break;

                case 2:
                    scanner.nextLine();

                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter student email: ");
                    String email = scanner.nextLine();

                    studentDAO.addStudent(name, email);
                    System.out.println("Student added successfully.");
                    break;

                case 3:
                    System.out.print("Enter student ID to remove: ");
                    int studentId = scanner.nextInt();

                    studentDAO.deleteStudent(studentId);
                    System.out.println("Student removed successfully.");
                    break;

                case 4:
                    scanner.nextLine();

                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();

                    System.out.print("Enter course credits: ");
                    int credits = scanner.nextInt();

                    courseDAO.addCourse(courseName, credits);
                    System.out.println("Course added successfully.");
                    break;

                case 5:
                    courseDAO.getCourses();
                    break;

                case 6:
                    System.out.print("Enter course ID to remove: ");
                    int courseIdToRemove = scanner.nextInt();

                    courseDAO.deleteCourse(courseIdToRemove);
                    System.out.println("Course removed successfully.");
                    break;

                case 7:
                    System.out.print("Enter student ID: ");
                    int enrollStudentId = scanner.nextInt();

                    System.out.print("Enter course ID: ");
                    int enrollCourseId = scanner.nextInt();

                    enrollmentDAO.addEnrollment(enrollStudentId, enrollCourseId);
                    System.out.println("Student enrolled successfully.");
                    break;

                case 8:
                    enrollmentDAO.getStudentCourses();
                    break;

                case 9:
                    System.out.println("Exiting University Management System.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 9);

        scanner.close();
        con.close();
    }
}