import java.util.ArrayList;

public class Hospital {


        private ArrayList<Patient> patients = new ArrayList<>();
        private ArrayList<Doctor> doctors = new ArrayList<>();
        private ArrayList<Appointment> appointments = new ArrayList<>();

        public void addPatient(Patient p) {
            patients.add(p);
        }

        public void addDoctor(Doctor d) {
            doctors.add(d);
        }

        public void createAppointment(Appointment a) {
            appointments.add(a);
        }

        public void showAllAppointments() {
            for (Appointment a : appointments) {
                a.showAppointment();
                System.out.println("-------------------");
            }
        }

}
