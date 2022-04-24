package dental.clinic.Service.impl;

import dental.clinic.DTO.DentistDTO;
import dental.clinic.services.IDentistService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DentistServiceTest {

    @Autowired
    private IDentistService dentistService;

    @Test
    public void createDentistTest(){
        DentistDTO dentistDTO = new DentistDTO();
        dentistDTO.setName("Lionel");
        dentistDTO.setLastName("Messi");
        dentistDTO.setRegistration("101010");
        DentistDTO newDentist = dentistService.create(dentistDTO);
        assertNotNull(newDentist);
    }
    @Test
    public void findByIdTest(){
        DentistDTO dentistDTO = new DentistDTO();
        dentistDTO.setName("Lionel");
        dentistDTO.setLastName("Messi");
        dentistDTO.setRegistration("101010");
        DentistDTO newDentist = dentistService.create(dentistDTO);
        DentistDTO dentistById = dentistService.findById(1);
        assertNotNull(dentistById);
    }
    @Test
    public void updateDentistTest(){
        DentistDTO dentistDTO = new DentistDTO();
        dentistDTO.setName("Lionel");
        dentistDTO.setLastName("Messi");
        dentistDTO.setRegistration("101010");
        DentistDTO newDentist = dentistService.create(dentistDTO);
        assertNotNull(dentistService.update(dentistDTO));
    }
    @Test
    public void findAllTest(){
        DentistDTO dentistDTO = new DentistDTO();
        dentistDTO.setName("Lionel");
        dentistDTO.setLastName("Messi");
        dentistDTO.setRegistration("101010");
        DentistDTO newDentist = dentistService.create(dentistDTO);
        assertTrue(dentistService.findAll().size()>0);
    }
    @Test
    public void deleteByIdTest(){
        DentistDTO dentistDTO = new DentistDTO();
        dentistDTO.setName("Lionel");
        dentistDTO.setLastName("Messi");
        dentistDTO.setRegistration("101010");
        DentistDTO newDentist = dentistService.create(dentistDTO);
        dentistService.deleteById(1);
        DentistDTO dentistTest = dentistService.findById(1);
        assertNull(dentistTest);
    }
}
