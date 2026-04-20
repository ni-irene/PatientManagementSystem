public class Main {

        public static void main(String[] args) {

            Hospital hospital = new Hospital();

            Patient p1 = new Patient(1, "Alice", "Flu");
            Patient p2 = new Patient(2, "Bob", "Malaria");

            Doctor d1 = new Doctor(101, "Dr. Smith", "General");
            Doctor d2 = new Doctor(102, "Dr. John", "Cardiology");

            hospital.addPatient(p1);
            hospital.addPatient(p2);

            hospital.addDoctor(d1);
            hospital.addDoctor(d2);

            Appointment a1 = new Appointment(p1, d1, "20-Apr-2026");
            Appointment a2 = new Appointment(p2, d2, "21-Apr-2026");

            hospital.createAppointment(a1);
            hospital.createAppointment(a2);

            hospital.showAllAppointments();
        }

}
