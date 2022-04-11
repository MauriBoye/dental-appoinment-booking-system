package dental.clinic.DTO;

import dental.clinic.entities.Adress;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientDTO {

    private Integer id;
    private String name;
    private String lastName;
    private String dni;
    private LocalDate entryDate;
    private Adress adress;
}
