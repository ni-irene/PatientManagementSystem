import java.time.LocalTime;

public class Appointment {

        private Patient patient;
        private Doctor doctor;
        private String date;
        private LocalTime time;

        public Appointment(Patient patient, Doctor doctor, String date, LocalTime time) {
            this.patient = patient;
            this.doctor = doctor;
            this.date = date;
            this.time = time;
        }

        public Patient getPatient() { return patient; }
        public Doctor getDoctor() { return doctor; }
        public String getDate() { return date; }
        public LocalTime getTime() { return time; }

        public void showAppointment() {
            System.out.println(patient.getName() + " → " + doctor.getName() +
                    " on " + date + " at " + time);
        }

}

