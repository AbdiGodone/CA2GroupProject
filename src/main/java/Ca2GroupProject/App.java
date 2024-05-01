package Ca2GroupProject;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static int upperBound;
    private static LinkedList<Patient>[] doctorsQueue;

    public static void main(String[] args) {
        System.out.print("Enter the upper bound for the queue: ");
        upperBound = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter the number of doctors: ");
        int numDoctors = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        doctorsQueue = new LinkedList[numDoctors];
        for (int i = 0; i < numDoctors; i++) {
            doctorsQueue[i] = new LinkedList<>();
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a new patient");
            System.out.println("2. Delete a patient");
            System.out.println("3. Display all patients");
            System.out.println("4. Create a new appointment");
            System.out.println("5. Call the next patient for a specified doctor");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    deletePatient();
                    break;
                case 3:
                    displayAllPatients();
                    break;
                case 4:
                    createAppointment();
                    break;
                case 5:
                    callNextPatient();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }


    }
    /**
     * Prompts the user to add a new patient to the system.
     * The method prompts the user to enter the patient's first name, last name, and date of birth.
     * If the patient already exists in the system, a message is displayed indicating that the patient already exists, and the method returns.
     * After entering the patient's details, the user is prompted to enter the doctor's name.
     * If the entered doctor's name is invalid, a message is displayed, and the method returns.
     * If the patient does not exist and the doctor's name is valid, a new Patient object is created with the provided details and the current date as the join date.
     * The patient is then added to the queue of patients for the corresponding doctor.
     * If the patient is added successfully, a message indicating success is displayed.
     */
    private static void addPatient() {
        System.out.println("\nAdding a new patient:");
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter date of birth (YYYY-MM-DD): ");
        LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());

        // Check if the patient already exists
        if (patientExists(firstName, lastName, dateOfBirth)) {
            System.out.println("Patient already exists.");
            return;
        }

        System.out.print("Enter doctor's name: ");
        String doctorName = scanner.nextLine().toLowerCase();
        int doctorIndex = getDoctorIndex(doctorName);
        if (doctorIndex == -1) {
            System.out.println("Invalid doctor name.");
            return;
        }

        Patient patient = new Patient(firstName, lastName, dateOfBirth, LocalDate.now());
        doctorsQueue[doctorIndex].add(patient);
        System.out.println("Patient added successfully.");
    }
    /**
     * Checks if a patient with the given first name, last name, and date of birth already exists in the system.
     *
     * @param firstName  the first name of the patient to check
     * @param lastName   the last name of the patient to check
     * @param dateOfBirth the date of birth of the patient to check
     * @return true if a patient with the given details exists in the system, false otherwise
     */
    private static boolean patientExists(String firstName, String lastName, LocalDate dateOfBirth) {
        for (LinkedList<Patient> queue : doctorsQueue) {
            for (Patient patient : queue) {
                if (patient.getFirstName().equalsIgnoreCase(firstName) &&
                        patient.getSecondName().equalsIgnoreCase(lastName) &&
                        patient.getDateOfBirth().equals(dateOfBirth)) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Gets the index of the doctor in the doctorsQueue array based on the provided doctor's name.
     *
     * @param doctorName the name of the doctor to find the index for
     * @return the index of the doctor in the doctorsQueue array if found, or -1 if not found
     */
    private static int getDoctorIndex(String doctorName) {
        for (int i = 0; i < doctorsQueue.length; i++) {
            if (doctorName.equalsIgnoreCase("doctor" + (i + 1))) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Prompts the user to delete a patient from the system.
     * The method prompts the user to enter the patient's first name, last name, and date of birth.
     * It then searches for the patient in the queues of all doctors.
     * If the patient is found, it is removed from the queue of the corresponding doctor.
     * If the patient is not found, a message is displayed indicating that the patient was not found.
     */
    private static void deletePatient() {
        System.out.println("\nDeleting a patient:");
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter date of birth (YYYY-MM-DD): ");
        LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());

        // Find the patient in the queues
        int doctorIndex = -1;
        int patientIndex = -1;
        for (int i = 0; i < doctorsQueue.length; i++) {
            LinkedList<Patient> queue = doctorsQueue[i];
            for (int j = 0; j < queue.size(); j++) {
                Patient patient = queue.get(j);
                if (patient.getFirstName().equalsIgnoreCase(firstName) &&
                        patient.getSecondName().equalsIgnoreCase(lastName) &&
                        patient.getDateOfBirth().equals(dateOfBirth)) {
                    doctorIndex = i;
                    patientIndex = j;
                    break;
                }
            }
            if (doctorIndex != -1 && patientIndex != -1) {
                break;
            }
        }

        // If patient is found, remove from queue
        if (doctorIndex != -1 && patientIndex != -1) {
            Patient removedPatient = doctorsQueue[doctorIndex].remove(patientIndex);
            System.out.println("Patient deleted successfully: " + removedPatient);
        } else {
            System.out.println("Patient not found.");
        }
    }
    /**
     * Displays all patients in the system.
     * This method iterates over the queues of all doctors and prints information about each patient.
     * For each patient, it prints their details including first name, last name, date of birth, and date joined.
     */
    private static void displayAllPatients() {
        System.out.println("\nAll Patients:");
        for (LinkedList<Patient> queue : doctorsQueue) {
            for (Patient patient : queue) {
                System.out.println(patient);
            }
        }
    }


}
