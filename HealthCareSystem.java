import java.util.*;

// Abstract class (Abstraction): This class is used to define common properties for Person and hide implementation details.
abstract class Person {
    private String name; 
    private int age;    

  
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter methods (Encapsulation)
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    //  (Abstraction): Every subclass must implement this method
    public abstract void displayInfo();
}

// Doctor class (Inheritance): Doctor is a subclass of Person, inheriting its fields and methods.
class Doctor extends Person {
    private String specialty;
    private boolean isAvailable;

    // Constructor for Doctor (uses the parent class constructor)
    public Doctor(String name, int age, String specialty) {
        super(name, age);  // Calls the constructor of the parent class
        this.specialty = specialty;
        this.isAvailable = true; // Initially, all doctors are available
    }

    // Getter methods (Encapsulation)
    public String getSpecialty() {
        return specialty;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Setter method (Encapsulation)
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    // Method overriding (Polymorphism): This method is specific to Doctor and is implemented here
    @Override
    public void displayInfo() {
        System.out.println("Doctor Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Specialty: " + specialty);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
    }
}

// Patient class (Inheritance): Patient is a subclass of Person, inheriting its fields and methods.
class Patient extends Person {
    private String ailment;
    private List<String> medicalHistory;

    // Constructor for Patient
    public Patient(String name, int age, String ailment) {
        super(name, age);  // Calls the constructor of the parent class
        this.ailment = ailment;
        this.medicalHistory = new ArrayList<>();
    }

    // Getter methods (Encapsulation)
    public String getAilment() {
        return ailment;
    }

    // Method to add to medical history (Encapsulation)
    public void addMedicalHistory(String record) {
        medicalHistory.add(record);
    }

    // Getter method (Encapsulation)
    public List<String> getMedicalHistory() {
        return medicalHistory;
    }

    // Method overriding (Polymorphism): This method is specific to Patient and is implemented here
    @Override
    public void displayInfo() {
        System.out.println("Patient Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Ailment: " + ailment);
        System.out.println("Medical History: " + medicalHistory);
    }
}

// Appointment class: Used to store the details of a doctor's appointment with a patient.
class Appointment {
    private Doctor doctor;
    private Patient patient;
    private String date;

    // Constructor for Appointment
    public Appointment(Doctor doctor, Patient patient, String date) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
    }

    // Method to display appointment details
    public void displayAppointmentDetails() {
        System.out.println("\n=== Appointment Details ===");
        System.out.println("Patient: " + patient.getName());
        System.out.println("Doctor: " + doctor.getName());
        System.out.println("Date: " + date);
        System.out.println("Specialty: " + doctor.getSpecialty());
    }
}

// Main class where the healthcare system is implemented
public class HealthCareSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Predefined list of doctors
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Dr. Catipay", 45, "Cardiology"));
        doctors.add(new Doctor("Dr. Longganisa", 40, "Cardiology"));
        doctors.add(new Doctor("Dr. Laja", 50, "Neurology"));
        doctors.add(new Doctor("Dr. Arvesu", 55, "Neurology"));
        doctors.add(new Doctor("Dr. Dermayuga", 38, "Dermatology"));
        doctors.add(new Doctor("Dr. Balmes", 41, "Dermatology"));
        doctors.add(new Doctor("Dr. Sendin", 42, "Pediatrics"));
        doctors.add(new Doctor("Dr. Lex", 45, "Pediatrics"));


        // Enhanced Illness-to-specialty mapping with more detailed categories
        Map<String, String> illnessToSpecialty = new HashMap<>();
        illnessToSpecialty.put("Chest Pain", "Cardiology");
        illnessToSpecialty.put("Heart Murmur", "Cardiology");
        illnessToSpecialty.put("High Blood Pressure", "Cardiology");
        illnessToSpecialty.put("Headache", "Neurology");
        illnessToSpecialty.put("Migraine", "Neurology");
        illnessToSpecialty.put("Nerve Pain", "Neurology");
        illnessToSpecialty.put("Skin Rash", "Dermatology");
        illnessToSpecialty.put("Acne", "Dermatology");
        illnessToSpecialty.put("Eczema", "Dermatology");
        illnessToSpecialty.put("Child Vaccination", "Pediatrics");
        illnessToSpecialty.put("Childhood Infection", "Pediatrics");
        illnessToSpecialty.put("Growth Concerns", "Pediatrics");

        // Input Patient Details
        System.out.println("Enter Patient Details:");
        System.out.print("Name: ");
        String patientName = scanner.nextLine();
        System.out.print("Age: ");
        int patientAge = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        // Provide guidance for illness input
        System.out.println("\nAvailable Illness Categories:");
        System.out.println("Cardiology: Chest Pain, Heart Murmur, High Blood Pressure");
        System.out.println("Neurology: Headache, Migraine, Nerve Pain");
        System.out.println("Dermatology: Skin Rash, Acne, Eczema");
        System.out.println("Pediatrics: Child Vaccination, Childhood Infection, Growth Concerns");
        
        System.out.print("\nEnter specific ailment: ");
        String ailment = scanner.nextLine();

        Patient patient = new Patient(patientName, patientAge, ailment);

        // Match ailment to specialty
        String specialty = illnessToSpecialty.get(ailment);
        if (specialty == null) {
            System.out.println("No matching specialty found for the specified ailment.");
            scanner.close();
            return;
        }

        // Find available doctors based on the matched specialty
        List<Doctor> availableDoctors = new ArrayList<>();
        for (Doctor doctor : doctors) {
            if (doctor.getSpecialty().equalsIgnoreCase(specialty) && doctor.isAvailable()) {
                availableDoctors.add(doctor);
            }
        }

        // If no doctors are available
        if (availableDoctors.isEmpty()) {
            System.out.println("\nSorry, no doctor is available for the specified ailment.");
            scanner.close();
            return;
        }

        // List available doctors
        System.out.println("\nAvailable Doctors for " + ailment + ":");
        for (int i = 0; i < availableDoctors.size(); i++) {
            Doctor doctor = availableDoctors.get(i);
            System.out.println((i + 1) + ". " + doctor.getName() + " - Specialty: " + doctor.getSpecialty());
        }

        // Patient chooses a doctor
        System.out.print("\nSelect doctor number for appointment: ");
        int doctorChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Doctor selectedDoctor = availableDoctors.get(doctorChoice - 1);

        // Book appointment
        System.out.print("\nEnter appointment date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        Appointment appointment = new Appointment(selectedDoctor, patient, date);
        selectedDoctor.setAvailable(false); // Mark doctor as unavailable
        appointment.displayAppointmentDetails();

        // Update patient history
        patient.addMedicalHistory("Visited Dr. " + selectedDoctor.getName() + " on " + date);

        // Display patient's medical history
        System.out.println("\n=== Patient Medical History ===");
        for (String record : patient.getMedicalHistory()) {
            System.out.println(record);
        }

        // Close scanner
        scanner.close();
    }
}

//This project contributes to SDG 3: Good Health and Well-Being by improving access to quality healthcare services and 
//increasing the efficiency of the healthcare system. It ensures that patients are matched with the appropriate healthcare 
//professionals based on their specific ailments, optimizing the chances of receiving the right care. The system also enhances 
//efficiency by allowing patients to easily book appointments with available doctors and reducing administrative burdens. By tracking
// medical histories and providing a structured appointment scheduling system, the project promotes universal health coverage, supporting 
//inclusive and accessible healthcare. Additionally, it helps healthcare providers manage their availability, ensuring better service delivery
// and reducing overburdening. Ultimately, the project fosters a more sustainable healthcare system, improving both the patient and provider
//experience while supporting preventive care and reducing healthcare costs. Through its streamlined processes and educational features, 
//the project also helps improve health literacy, empowering patients to make informed decisions about their healthcare.Jo