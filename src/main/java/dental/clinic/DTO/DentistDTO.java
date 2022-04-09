package dental.clinic.DTO;

import lombok.Data;

@Data
public class DentistDTO {

    //Sin @Column ni @Table


    private Integer id;
    private String name;
    private String lastName;
    private String registration;

}
