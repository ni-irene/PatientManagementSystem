import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Doctor extends Person {


        private String specialization;

        // Set → unique time slots
        private Set<LocalTime> availableSlots = new HashSet<>();

        public Doctor(int id, String name, String specialization) {
            super(id, name);
            this.specialization = specialization;
        }

        public String getSpecialization() {
            return specialization;
        }

        public void addAvailableSlot(LocalTime time) {
            availableSlots.add(time);
        }

        public Set<LocalTime> getAvailableSlots() {
            return availableSlots;
        }

        @Override
        public void displayInfo() {
            System.out.println("Doctor: " + name + " | " + specialization);
        }
    }

