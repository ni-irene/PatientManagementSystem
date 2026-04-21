import java.time.LocalTime;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            Hospital hospital = new Hospital();

            // Sample data
            Patient p1 = new Patient(1, "Alice", "Flu");
            Doctor d1 = new Doctor(101, "Dr Smith", "General");

            hospital.addPatient(p1);
            hospital.addDoctor(d1);

            while (true) {
                System.out.println("\n===== PATIENT MANAGEMENT SYSTEM =====");
                System.out.println("1. Create Appointment");
                System.out.println("2. View Appointments");
                System.out.println("3. Exit");
                System.out.print("Choose option: ");

                int choice = sc.nextInt();

                try {
                    switch (choice) {

                        case 1:
                            System.out.print("Enter date (e.g. 20-Apr-2026): ");
                            String date = sc.next();

                            System.out.print("Enter hour (0-23): ");
                            int hour = sc.nextInt();

                            System.out.print("Enter minute (0-59): ");
                            int minute = sc.nextInt();

                            LocalTime time = LocalTime.of(hour, minute);

                            hospital.createAppointment(p1, d1, date, time);
                            break;

                        case 2:
                            hospital.showAllAppointments();
                            break;

                        case 3:
                            System.out.println("Exiting system...");
                            return;

                        default:
                            System.out.println("Invalid option!");
                    }

                } catch (InvalidTimeException e) {
                    System.out.println("⚠️ " + e.getMessage());

                } catch (DoctorUnavailableException e) {
                    System.out.println("⚠️ " + e.getMessage());

                } catch (Exception e) {
                    System.out.println("⚠️ Invalid input! Please try again.");
                    sc.nextLine(); // clear input buffer
                }
            }
        }



    }

