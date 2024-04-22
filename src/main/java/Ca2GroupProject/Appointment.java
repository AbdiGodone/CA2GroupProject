package Ca2GroupProject;

import java.time.LocalDate;
import java.util.Objects;

public class Appointment  implements  Comparable<Appointment>{
    private String patientFirstName;
    private String patientLastName;
    private LocalDate dateOfBirth;
    private String issue;
    private LocalDate date;
    private  int triageLevel;
    private String DoctorFullName;

    public Appointment(String patientFirstName, String patientLastName, LocalDate dateOfBirth, String issue, LocalDate date, int triageLevel, String doctorFullName){
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.dateOfBirth = dateOfBirth;
        this.issue = issue;
        this.date = date;
        this.triageLevel = triageLevel;
        this.DoctorFullName = doctorFullName;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTriageLevel() {
        return triageLevel;
    }


    public void setTriageLevel(int triageLevel) {
        this.triageLevel = triageLevel;
    }

    public String getDoctorFullName() {
        return DoctorFullName;
    }

    public void setDoctorFullName(String doctorFullName) {
        DoctorFullName = doctorFullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return triageLevel == that.triageLevel && Objects.equals(patientFirstName, that.patientFirstName) && Objects.equals(patientLastName, that.patientLastName) && Objects.equals(dateOfBirth, that.dateOfBirth) && Objects.equals(issue, that.issue) && Objects.equals(date, that.date) && Objects.equals(DoctorFullName, that.DoctorFullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientFirstName, patientLastName, dateOfBirth, issue, date, triageLevel, DoctorFullName);
    }


    @Override
    public int compareTo(Appointment o) {
        if (this.triageLevel !=o.triageLevel){
            return Integer.compare(this.triageLevel, o.triageLevel);
        }
        else {
            return this.date.compareTo(o.date);
        }

    }

    @Override
    public String toString() {
        return "Appointment{" +
                "patientFirstName='" + patientFirstName + '\'' +
                ", patientLastName='" + patientLastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", issue='" + issue + '\'' +
                ", date=" + date +
                ", triageLevel=" + triageLevel +
                ", DoctorFullName='" + DoctorFullName + '\'' +
                '}';
    }
}
