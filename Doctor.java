import java.util.HashSet;
import java.util.Set;
import java.time.LocalTime;

public class Doctor extends Person {

        private String specialization;

        // Unique relationship: no duplicate time slots
        // Using Set to ensure uniqueness
        private Set<LocalTime> availableSlots = new HashSet<>();

        public Doctor(int id, String name, String specialization) {
            super(id, name);
            this.specialization = specialization;
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
