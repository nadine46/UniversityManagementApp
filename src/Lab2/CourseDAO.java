package Lab2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseDAO {

    private Connection con;

    public CourseDAO(Connection con) {
        this.con = con;
    }

    public void getCourses() throws SQLException {
        String sql = "SELECT * FROM courses";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(
                    rs.getInt("course_id") + " " +
                            rs.getString("course_name") + " " +
                            rs.getInt("credits")
            );
        }

        rs.close();
        ps.close();
    }

    public void addCourse(String courseName, int credits) throws SQLException {
        String sql = "INSERT INTO courses (course_name, credits) VALUES (?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, courseName);
        ps.setInt(2, credits);

        ps.executeUpdate();
        ps.close();
    }

    public void deleteCourse(int courseId) throws SQLException {
        String sql = "DELETE FROM courses WHERE course_id = ?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, courseId);

        ps.executeUpdate();
        ps.close();
    }
}