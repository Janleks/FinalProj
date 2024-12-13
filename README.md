# **Healthcare System**

## **Overview**
The **Healthcare System** is a Java-based application designed to streamline patient-doctor interactions. This project serves as a platform where patients can be matched with suitable doctors based on their ailments, book appointments efficiently, and track their medical history. The system aims to enhance healthcare service delivery by reducing administrative burdens and improving accessibility to medical professionals. 

This project aligns with the **United Nations Sustainable Development Goal 3**: *Good Health and Well-Being*, by improving access to quality healthcare services, supporting preventive care, and optimizing healthcare resource management.

---

## **Features**

### **1. Patient Management**
- **Patient Registration**: Collects patient details such as name, age, and specific ailment.
- **Medical History Tracking**: Maintains a history of patient visits and appointments for future reference.

### **2. Doctor Management**
- **Predefined Doctor Database**: Includes a list of doctors with their specialties and availability status.
- **Specialty-Based Matching**: Filters doctors by their specialties (e.g., Cardiology, Neurology) to ensure appropriate care.

### **3. Appointment Scheduling**
- **Ailment-to-Specialty Mapping**: Links specific ailments to corresponding medical specialties using a mapping system.
- **Available Doctor Listing**: Lists doctors available for the selected specialty.
- **Appointment Booking**: Schedules an appointment with the selected doctor for a given date.
- **Dynamic Availability**: Marks doctors as unavailable once an appointment is booked.

### **4. Interactive Console Interface**
- User-friendly prompts guide patients through the registration and appointment process.
- Provides clear instructions and feedback to minimize errors.

---

## **Technologies Used**

### **Programming Language**
- **Java**: Core language used for implementing object-oriented programming concepts.

### **Core Concepts Utilized**
1. **Object-Oriented Programming (OOP)**:
   - **Abstraction**: Uses abstract classes (`Person`) to define shared attributes and behaviors for `Doctor` and `Patient`.
   - **Encapsulation**: Protects data by using private fields and providing access through getter and setter methods.
   - **Inheritance**: Derives specialized classes (`Doctor` and `Patient`) from the base `Person` class.
   - **Polymorphism**: Implements method overriding to provide custom behavior in `Doctor` and `Patient` classes.
2. **Collections Framework**:
   - Uses `ArrayList` to store doctors and manage patient data.
   - Employs `HashMap` for ailment-to-specialty mapping.
3. **User Input Handling**:
   - Captures user input through `Scanner` for dynamic interaction.
   - Validates input to ensure data consistency and error prevention.

### **Environment**
- Java Development Kit (JDK) 8 or above.
- IDEs like IntelliJ IDEA, Eclipse, or any text editor supporting Java.

---

## **Setup Instructions**

### **1. Prerequisites**
- Install **Java Development Kit (JDK)**.
- Use an IDE (e.g., IntelliJ, Eclipse) or text editor to edit and run the project.
- Familiarity with basic Java syntax and terminal/command-line usage.

### **2. Installation**
1. Download or clone the repository.
2. Open the `HealthCareSystem.java` file in your IDE.

### **3. Running the Application**
1. Compile the program:
   ```bash
   javac HealthCareSystem.java
