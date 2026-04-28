import java.io.*;
import java.time.LocalTime;
import java.util.*;

public class FileHandler {

        // PATIENTS
        public static void savePatients(List<Patient> patients) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("patients.txt"))) {
                for (Patient p : patients) {
                    writer.write(p.getId() + "," + p.getName() + "," + p.getIllness());
                    writer.newLine();
                }
            } catch (IOException e) {
                System.out.println("Error saving patients");
            }
        }

        public static List<Patient> loadPatients() {
            List<Patient> patients = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader("patients.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] d = line.split(",");
                    patients.add(new Patient(Integer.parseInt(d[0]), d[1], d[2]));
                }
            } catch (IOException e) {}
            return patients;
        }

        // DOCTORS
        public static void saveDoctors(List<Doctor> doctors) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("doctors.txt"))) {
                for (Doctor d : doctors) {
                    writer.write(d.getId() + "," + d.getName() + "," + d.getSpecialization());
                    writer.newLine();
                }
            } catch (IOException e) {}
        }

        public static List<Doctor> loadDoctors() {
            List<Doctor> doctors = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader("doctors.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] d = line.split(",");
                    doctors.add(new Doctor(Integer.parseInt(d[0]), d[1], d[2]));
                }
            } catch (IOException e) {}
            return doctors;
        }

        // APPOINTMENTS
        public static void saveAppointments(Map<Doctor, List<Appointment>> map) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("appointments.txt"))) {
                for (Doctor d : map.keySet()) {
                    for (Appointment a : map.get(d)) {
                        writer.write(d.getId() + "," + a.getPatient().getId() + "," + a.getDate() + "," + a.getTime());
                        writer.newLine();
                    }
                }
            } catch (IOException e) {}
        }

        public static void loadAppointments(Hospital hospital) {
            try (BufferedReader reader = new BufferedReader(new FileReader("appointments.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {

                    String[] d = line.split(",");
                    Doctor doc = hospital.findDoctorById(Integer.parseInt(d[0]));
                    Patient pat = hospital.findPatientById(Integer.parseInt(d[1]));

                    if (doc != null && pat != null) {
                        hospital.createAppointment(pat, doc, d[2], LocalTime.parse(d[3]));
                    }
                }
            } catch (IOException e) {}
        }
    }