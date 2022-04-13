package dental.clinic.DTO;

import dental.clinic.entities.Dentist;
import dental.clinic.entities.Patient;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AppointmentDTO {

    private Integer id;
    private LocalDate date;
    private LocalTime time;
    private Dentist dentist;
    private Patient patient;

}
