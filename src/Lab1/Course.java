package Lab1;

    public class Course {
        private int id;
        private String courseName;
        private int credits;
        private Instructor instructor;


        public Course(int id, String courseName, int credits, Instructor instructor) {
            this.id = id;
            this.courseName = courseName;
            this.credits = credits;
            this.instructor = instructor;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public int getCredits() {
            return credits;
        }

        public void setCredits(int credits) {
            this.credits = credits;
        }

        public Instructor getInstructor() {
            return instructor;
        }

        public void setInstructor(Instructor instructor) {
            this.instructor = instructor;
        }

        @Override
        public String toString() {
            return "Course{" +
                    "id=" + id +
                    ", courseName='" + courseName + '\'' +
                    ", credits=" + credits +
                    ", instructor=" + instructor +
                    '}';
        }

    }

