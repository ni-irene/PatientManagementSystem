# Patient Management System – Java Collections Implementation

##  Description

This project is an extension of the Patient Management System developed using Java.
It demonstrates the use of the **Java Collections Framework** to model real-world relationships between objects in a hospital environment.

The focus of this version is to replace simple data storage with appropriate collections such as **List, Set, and Map** to improve system design and accuracy.

---

##  Objective

To apply the correct Java collection types in order to represent relationships between entities such as patients, doctors, and appointments.

---

##  Collections Used & Justification

###  1. List (One-to-Many Relationship)

```java
List<Patient> patients;
List<Doctor> doctors;
```

* Used to represent a **one-to-many relationship**
* A hospital can have multiple patients and doctors
* Allows ordered storage and duplicates if necessary

---

###  2. Set (Unique Relationship)

```java
Set<LocalTime> availableSlots;
```

* Used to store **unique time slots**
* Prevents duplicate appointment times for doctors
* Ensures data integrity

---

###  3. Map (Key-Value Relationship)

```java
Map<Doctor, List<Appointment>> doctorAppointments;
```

* Used for **fast lookup**
* Each doctor is associated with multiple appointments
* Represents a real-world scheduling system

---

##  Combined Collections

The system uses a **combined collection structure**:

```java
Map<Doctor, List<Appointment>>
```

This allows:

* Efficient grouping of appointments per doctor
* Better organization of scheduling data

---

##  Operations Performed

###  List

* Add patients/doctors
* Remove patients
* Retrieve all records

###  Set

* Add available time slots
* Prevent duplicate entries

###  Map

* Store doctor-appointment relationships
* Retrieve appointments by doctor

---

##  Real-World Modeling

The system models real-life relationships:

* A **Hospital has many Patients and Doctors** → List
* A **Doctor has unique available time slots** → Set
* A **Doctor has multiple Appointments** → Map

This approach ensures accurate representation of real-world hospital operations.

---

##  OOP Principles Used

* **Encapsulation** – Private fields with getters/setters
* **Inheritance** – `Person` → `Patient` and `Doctor`
* **Polymorphism** – Method overriding
* **Abstraction** – Abstract class usage

---

##  How to Run

1. Compile all `.java` files
2. Run `Main.java`
3. Use the menu system to interact with the program

---

##  Branch Information

This implementation is available in the branch:

```
java-collection
```

---

##  Conclusion

This project demonstrates how the Java Collections Framework can be used to move from simple data storage to **modeling real-world relationships effectively**, resulting in a more scalable, efficient, and well-structured system.
