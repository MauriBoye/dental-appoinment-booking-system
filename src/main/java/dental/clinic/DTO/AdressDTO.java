package dental.clinic.DTO;

import lombok.Data;


@Data
public class AdressDTO {

    private Integer id;
    private String street;
    private String number;
    private String city;
    private String state;

}
