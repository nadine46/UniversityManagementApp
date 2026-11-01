package Lab1;


    public class GraduateStudent extends Student {
        private double gpa;

        public GraduateStudent(int id, String name, String email, double gpa) {
            super(id, name, email);
            this.gpa = gpa;
        }
        @Override
        public double calculateGPA() {
            return gpa;
        }

        public void setGpa(double gpa) {
            this.gpa = gpa;
        }
    }


