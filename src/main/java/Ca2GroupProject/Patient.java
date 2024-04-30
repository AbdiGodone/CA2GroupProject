package Ca2GroupProject;
import java.time.LocalDate;
import java.util.Objects;

public class Patient {
    private String firstName;
    private String secondName;
    private LocalDate dateOfBirth;
    private LocalDate dateJoined;

    //    private AppointmentLinkedList appointments;
    public Patient() {
    }

    public Patient(String firstName, String secondName, LocalDate dateOfBirth, LocalDate dateJoined) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.dateOfBirth = dateOfBirth;
        this.dateJoined = dateJoined;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(firstName, patient.firstName) && Objects.equals(secondName, patient.secondName) && Objects.equals(dateOfBirth, patient.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, dateOfBirth);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateJoined=" + dateJoined +
                '}';
    }
}
