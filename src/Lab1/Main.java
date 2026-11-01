package Lab1;

    public class Main {
        public static void main(String[] args) {
            University university = new University();

            Instructor instructor = new Instructor(
                    1, "Grace Uwase", "grace@example.com", "IT"
            );

            Course course = new Course(
                    101, "Java Programming", 4, instructor
            );

            UndergraduateStudent undergraduate = new UndergraduateStudent(
                    1, "Alice", "alice@example.com", 3.6
            );

            GraduateStudent graduate = new GraduateStudent(
                    2, "David", "david@example.com", 3.9
            );

            university.addInstructor(instructor);
            university.addCourse(course);
            university.addStudent(undergraduate);
            university.addStudent(graduate);

            System.out.println("STUDENTS:");
            for (Student student : university.getStudents()) {
                System.out.println(student);
                System.out.println("GPA: " + student.calculateGPA());
            }

            System.out.println("\nCOURSES:");
            for (Course c : university.getCourses()) {
                System.out.println(c);
            }

            System.out.println("\nINSTRUCTORS:");
            for (Instructor i : university.getInstructors().values()) {
                System.out.println(i);
            }
        }
    }

