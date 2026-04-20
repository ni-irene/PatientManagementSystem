public class Appointment {
        private Patient patient;
        private Doctor doctor;
        private String date;

        public Appointment(Patient patient, Doctor doctor, String date) {
            this.patient = patient;
            this.doctor = doctor;
            this.date = date;
        }

        public void showAppointment() {
            System.out.println("Appointment Date: " + date);
            patient.displayInfo();
            doctor.displayInfo();
        }

}
