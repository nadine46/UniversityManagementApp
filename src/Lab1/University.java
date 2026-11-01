package Lab1;

import java.util.*;

    public class University {
        private List<Student> students = new ArrayList<>();
        private Set<Course> courses = new HashSet<>();
        private Map<Integer, Instructor> instructors = new HashMap<>();

        public void addStudent(Student student) {
            students.add(student);
        }

        public void addCourse(Course course) {
            courses.add(course);
        }

        public void addInstructor(Instructor instructor) {
            instructors.put(instructor.getId(), instructor);
        }

        public List<Student> getStudents() {
            return students;
        }

        public Set<Course> getCourses() {
            return courses;
        }

        public Map<Integer, Instructor> getInstructors() {
            return instructors;
        }
    }

