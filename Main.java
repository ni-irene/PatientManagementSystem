import java.time.LocalTime;

public class Main {

        public static void main(String[] args) {

            Hospital hospital = new Hospital();

            Patient p1 = new Patient(1, "Alice", "Flu");
            Doctor d1 = new Doctor(101, "Dr Smith", "General");

            hospital.addPatient(p1);
            hospital.addDoctor(d1);

            // Add available slots (Set → no duplicates)
            d1.addAvailableSlot(LocalTime.of(10,0));
            d1.addAvailableSlot(LocalTime.of(10,0)); // ignored

            // Create appointment
            hospital.createAppointment(p1, d1, "20-Apr-2026", LocalTime.of(10,0));

            // View appointments
            hospital.showAppointmentsByDoctor(d1);

            // Remove patient
            hospital.removePatient(p1);
        }
    }

// List is used to represent one-to-many relationship (Hospital → Patients)
// Set is used to store unique time slots (no duplicates)
// Map is used for key-value mapping (Doctor → Appointments)