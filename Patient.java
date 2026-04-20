public class Patient extends Person {
        private String illness;

        public Patient(int id, String name, String illness) {
            super(id, name);
            this.illness = illness;
        }

        public String getIllness() {
            return illness;
        }

        public void setIllness(String illness) {
            this.illness = illness;
        }

        @Override
        public void displayInfo() {
            System.out.println("Patient ID: " + id + ", Name: " + name + ", Illness: " + illness);
        }

}
