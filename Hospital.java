import java.time.LocalTime;
import java.util.*;

public class Hospital {

        // List → one-to-many
        private List<Patient> patients = new ArrayList<>();
        private List<Doctor> doctors = new ArrayList<>();

        // Map → Doctor → Appointments
        private Map<Doctor, List<Appointment>> doctorAppointments = new HashMap<>();

        public void addPatient(Patient p) {

            // Prevent duplicate patients
            for (Patient existing : patients) {
                if (existing.getId() == p.getId()) {
                    return;
                }
            }

            patients.add(p);
        }

        public void addDoctor(Doctor d) {
            doctors.add(d);
            doctorAppointments.put(d, new ArrayList<>());
        }

        public List<Patient> getPatients() { return patients; }
        public List<Doctor> getDoctors() { return doctors; }
        public Map<Doctor, List<Appointment>> getDoctorAppointments() { return doctorAppointments; }

        public Doctor findDoctorById(int id) {
            for (Doctor d : doctors) {
                if (d.getId() == id) return d;
            }
            return null;
        }

        public Patient findPatientById(int id) {
            for (Patient p : patients) {
                if (p.getId() == id) return p;
            }
            return null;
        }

        public void createAppointment(Patient p, Doctor d, String date, LocalTime time) {

            if (time.isBefore(LocalTime.of(9, 0)) || time.isAfter(LocalTime.of(17, 0))) {
                throw new InvalidTimeException("Outside working hours!");
            }

            List<Appointment> list = doctorAppointments.get(d);

            for (Appointment a : list) {
                if (a.getDate().equals(date) && a.getTime().equals(time)) {
                    throw new DoctorUnavailableException("Doctor already booked!");
                }
            }

            list.add(new Appointment(p, d, date, time));
        }

        public void showAppointments() {
            for (Doctor d : doctorAppointments.keySet()) {
                for (Appointment a : doctorAppointments.get(d)) {
                    a.showAppointment();
                }
            }
        }

}


