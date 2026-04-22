import java.util.*;
import java.time.LocalTime;

public class Hospital {

    // One-to-Many: One hospital → many patients
    // Using List because order matters and duplicates allowed
    private List<Patient> patients = new ArrayList<>();

    // One-to-Many: One hospital → many doctors
    private List<Doctor> doctors = new ArrayList<>();

    // Key-Value: Doctor → List of appointments
    // Using Map for fast lookup of appointments by doctor
    private Map<Doctor, List<Appointment>> doctorAppointments = new HashMap<>();

    public void addPatient(Patient p) {
        patients.add(p);
    }

    public void addDoctor(Doctor d) {
        doctors.add(d);

        // Initialize doctor entry in map
        doctorAppointments.put(d, new ArrayList<>());
    }

    public void createAppointment(Patient p, Doctor d, String date, LocalTime time) {

        // Time validation
        if (time.isBefore(LocalTime.of(9, 0)) || time.isAfter(LocalTime.of(17, 0))) {
            throw new RuntimeException("Invalid time!");
        }

        List<Appointment> appointments = doctorAppointments.get(d);

        // Check double booking
        for (Appointment a : appointments) {
            if (a.getDate().equals(date) && a.getTime().equals(time)) {
                throw new RuntimeException("Doctor already booked!");
            }
        }

        Appointment newApp = new Appointment(p, d, date, time);
        appointments.add(newApp);

        System.out.println("Appointment created!");
    }

    public void showAppointmentsByDoctor(Doctor d) {
        List<Appointment> apps = doctorAppointments.get(d);

        for (Appointment a : apps) {
            a.showAppointment();
        }
    }

    public void removePatient(Patient p) {
        patients.remove(p);
    }
}