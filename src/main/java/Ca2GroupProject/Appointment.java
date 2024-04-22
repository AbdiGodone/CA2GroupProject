package Ca2GroupProject;

import java.time.LocalDate;

public class Appointment {
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


}
