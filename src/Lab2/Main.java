package Lab2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/University_db", "postgres", "ikofi123");
        StudentDAO studentDAO = new StudentDAO(con);
        studentDAO.addStudent("Alice", "alice@example.com");
        System.out.println("Student added successfully");
        studentDAO.getStudents();
        CourseDAO courseDAO = new CourseDAO(con);
        courseDAO.getCourses();
        EnrollmentDAO enrollmentDAO = new EnrollmentDAO(con);
        enrollmentDAO.getStudentCourses();

    }
}