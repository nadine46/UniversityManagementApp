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
    }

