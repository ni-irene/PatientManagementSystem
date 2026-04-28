# Patient Management System (Java OOP + Collections + File I/O)

##  Description

This project is a **Patient Management System** developed in Java to simulate real-world hospital operations.
It demonstrates core programming concepts including **Object-Oriented Programming (OOP)**, **Java Collections Framework**, **Exception Handling**, and **File I/O (data persistence)**.

The system allows managing patients, doctors, and appointments while ensuring data is saved and restored from files.

---

##  Objectives

* Model real-world hospital relationships using OOP
* Use appropriate Java Collections (List, Set, Map)
* Handle errors using exceptions
* Persist data using file input/output

---

##  OOP Concepts Applied

* **Encapsulation** → Private fields with getters
* **Inheritance** → `Person` → `Patient`, `Doctor`
* **Polymorphism** → Method overriding (`displayInfo`)
* **Abstraction** → Abstract class `Person`

---

##  Java Collections Used

###  List (One-to-Many)

```java
List<Patient> patients;
List<Doctor> doctors;
```

* Represents a hospital having multiple patients and doctors

---

###  Set (Unique Values)

```java
Set<LocalTime> availableSlots;
```

* Ensures no duplicate time slots for doctors

---

###  Map (Key-Value Relationship)

```java
Map<Doctor, List<Appointment>> doctorAppointments;
```

* Maps each doctor to their appointments
* Allows fast lookup and efficient scheduling

---

##  Exception Handling

###  Custom Exceptions:

* `InvalidTimeException` → prevents invalid working hours
* `DoctorUnavailableException` → prevents double booking

###  Purpose:

* Avoid program crashes
* Enforce business rules
* Provide meaningful error messages

---

##  File I/O (Data Persistence)

### Files Used:

```text
patients.txt
doctors.txt
appointments.txt
```

###  Features:

* Save data when program exits
* Load data when program starts
* Maintain relationships using IDs

###  Example Data Format:

```
patients.txt → id,name,illness
doctors.txt → id,name,specialization
appointments.txt → doctorId,patientId,date,time
```

---

##  System Workflow

1. Load patients, doctors, and appointments from files
2. Add new data (only if not already existing)
3. Create appointments with validation
4. Display stored data
5. Save all data back to files

---

##  Key Features

* Prevents duplicate patients
* Prevents doctor double-booking
* Validates working hours (09:00–17:00)
* Stores and restores data using files
* Models real-world relationships correctly

---

##  How to Run

1. Open project in your Java IDE
2. Compile all `.java` files
3. Run `Main.java`
4. Check generated `.txt` files for saved data

---


##  Conclusion

This system demonstrates how to combine **OOP, Collections, Exception Handling, and File I/O** to build a realistic and robust application.
It moves from simple in-memory data storage to **persistent, structured data management**, similar to real-world systems.

---
