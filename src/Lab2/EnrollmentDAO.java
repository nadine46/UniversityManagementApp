package Lab2;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

    public class EnrollmentDAO {

        private Connection con;

        public EnrollmentDAO(Connection con) {
            this.con = con;
        }

        public void updateEnrollment(int enrollmentId, int studentId, int courseId) throws SQLException {
            String sql = "UPDATE enrollments SET student_id = ?, course_id = ? WHERE enrollment_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            ps.setInt(3, enrollmentId);

            ps.executeUpdate();
            ps.close();
        }
        public void getStudentCourses() throws SQLException {
            String sql = "SELECT students.name, courses.course_name " +
                    "FROM enrollments " +
                    "JOIN students ON enrollments.student_id = students.student_id " +
                    "JOIN courses ON enrollments.course_id = courses.course_id";

            PreparedStatement ps = con.prepareStatement(sql);
            var rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getString("name") + " - " +
                                rs.getString("course_name")
                );
            }

            rs.close();
            ps.close();
        }
    }

