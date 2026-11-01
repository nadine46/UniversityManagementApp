 package Lab2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

    public class StudentDAO {

        private Connection con;

        public StudentDAO(Connection con) {
            this.con = con;
        }

        public void addStudent(String name, String email) throws SQLException {
            String sql = "INSERT INTO students (name, email) VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);

            ps.executeUpdate();
            ps.close();
        }

        public void getStudents() throws SQLException {
            String sql = "SELECT * FROM students";
            PreparedStatement ps = con.prepareStatement(sql);
            var rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("student_id") + " " +
                                rs.getString("name") + " " +
                                rs.getString("email")
                );
            }

            rs.close();
            ps.close();
        }

        public void updateStudent(int id, String name, String email) throws SQLException {
            String sql = "UPDATE students SET name = ?, email = ? WHERE student_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setInt(3, id);

            ps.executeUpdate();
            ps.close();
        }

        public void deleteStudent(int id) throws SQLException {
            String sql = "DELETE FROM students WHERE student_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            ps.close();
        }
    }

