package Lab3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import Lab2.StudentDAO;
import Lab2.CourseDAO;
import Lab2.EnrollmentDAO;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/University_db";
        String username = "postgres";
        String password = "ikofi123";

        try (
                Connection con = DriverManager.getConnection(url, username, password);
                Scanner scanner = new Scanner(System.in)
        ) {
            StudentDAO studentDAO = new StudentDAO(con);
            CourseDAO courseDAO = new CourseDAO(con);
            EnrollmentDAO enrollmentDAO = new EnrollmentDAO(con);

            boolean running = true;

            while (running) {
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
                System.out.flush();

                String input = scanner.nextLine();

                int choice;

                try {
                    choice = Integer.parseInt(input.trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number from 1 to 9.");
                    continue;
                }

                try {
                    switch (choice) {
                        case 1:
                            studentDAO.getStudents();
                            break;

                        case 2:
                            System.out.print("Enter student name: ");
                            String name = scanner.nextLine();

                            System.out.print("Enter student email: ");
                            String email = scanner.nextLine();

                            studentDAO.addStudent(name, email);
                            System.out.println("Student added successfully.");
                            break;

                        case 3:
                            System.out.print("Enter student ID to remove: ");
                            int studentId = Integer.parseInt(scanner.nextLine().trim());

                            studentDAO.deleteStudent(studentId);
                            System.out.println("Student removed successfully.");
                            break;

                        case 4:
                            System.out.print("Enter course name: ");
                            String courseName = scanner.nextLine();

                            System.out.print("Enter course credits: ");
                            int credits = Integer.parseInt(scanner.nextLine().trim());

                            courseDAO.addCourse(courseName, credits);
                            System.out.println("Course added successfully.");
                            break;

                        case 5:
                            courseDAO.getCourses();
                            break;

                        case 6:
                            System.out.print("Enter course ID to remove: ");
                            int courseId = Integer.parseInt(scanner.nextLine().trim());

                            courseDAO.deleteCourse(courseId);
                            System.out.println("Course removed successfully.");
                            break;

                        case 7:
                            System.out.print("Enter student ID: ");
                            int enrollStudentId = Integer.parseInt(scanner.nextLine().trim());

                            System.out.print("Enter course ID: ");
                            int enrollCourseId = Integer.parseInt(scanner.nextLine().trim());

                            enrollmentDAO.addEnrollment(enrollStudentId, enrollCourseId);
                            System.out.println("Student enrolled successfully.");
                            break;

                        case 8:
                            enrollmentDAO.getStudentCourses();
                            break;

                        case 9:
                            running = false;
                            System.out.println("Exiting University Management System.");
                            break;

                        default:
                            System.out.println("Invalid choice. Please enter a number from 1 to 9.");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Please enter a valid integer.");
                } catch (SQLException e) {
                    System.out.println("Database operation failed: " + e.getMessage());
                }
            }

        } catch (SQLException e) {
            System.out.println("Could not connect to the database: " + e.getMessage());
        }
    }
}