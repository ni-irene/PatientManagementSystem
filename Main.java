import java.time.LocalTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Hospital hospital = new Hospital();

        // LOAD DATA
        List<Patient> patients = FileHandler.loadPatients();
        for (Patient p : patients) hospital.addPatient(p);

        List<Doctor> doctors = FileHandler.loadDoctors();
        for (Doctor d : doctors) hospital.addDoctor(d);

        FileHandler.loadAppointments(hospital);

        // Add only if empty (avoid duplicates)
        if (hospital.getPatients().isEmpty()) {
            hospital.addPatient(new Patient(1, "Alice", "Flu"));
        }

        if (hospital.getDoctors().isEmpty()) {
            hospital.addDoctor(new Doctor(101, "Dr Smith", "General"));
        }

        try {
            Patient p = hospital.findPatientById(1);
            Doctor d = hospital.findDoctorById(101);

            hospital.createAppointment(p, d, "20-Apr-2026", LocalTime.of(10, 0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        hospital.showAppointments();

        // SAVE DATA
        FileHandler.savePatients(hospital.getPatients());
        FileHandler.saveDoctors(hospital.getDoctors());
        FileHandler.saveAppointments(hospital.getDoctorAppointments());
    }
}

