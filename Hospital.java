import java.util.ArrayList;
import java.time.LocalTime;

public class Hospital {

        private ArrayList<Patient> patients = new ArrayList<>();
        private ArrayList<Doctor> doctors = new ArrayList<>();
        private ArrayList<Appointment> appointments = new ArrayList<>();

        public void addPatient(Patient p) {
            if (p == null) {
                throw new IllegalArgumentException("Patient cannot be null");
            }
            patients.add(p);
        }

        public void addDoctor(Doctor d) {
            if (d == null) {
                throw new IllegalArgumentException("Doctor cannot be null");
            }
            doctors.add(d);
        }

        public void createAppointment(Patient p, Doctor d, String date, LocalTime time) {

            if (p == null || d == null) {
                throw new IllegalArgumentException("Patient or Doctor is missing!");
            }

            //  Time validation
            LocalTime start = LocalTime.of(9, 0);
            LocalTime end = LocalTime.of(17, 0);

            if (time.isBefore(start) || time.isAfter(end)) {
                throw new InvalidTimeException("Invalid time! Allowed: 09:00 - 17:00");
            }

            //  Double booking check
            for (Appointment a : appointments) {
                if (a.getDoctor() == d &&
                        a.getDate().equals(date) &&
                        a.getTime().equals(time)) {

                    throw new DoctorUnavailableException("Doctor already booked at this time!");
                }
            }

            Appointment newAppointment = new Appointment(p, d, date, time);
            appointments.add(newAppointment);

            System.out.println(" Appointment created successfully!");
        }

        public void showAllAppointments() {
            for (Appointment a : appointments) {
                a.showAppointment();
                System.out.println("-------------------");
            }
        }


}
