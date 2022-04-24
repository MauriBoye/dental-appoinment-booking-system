package dental.clinic.Service.impl;


import dental.clinic.DTO.PatientDTO;
import dental.clinic.entities.Adress;
import dental.clinic.services.IPatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private IPatientService patientService;

    @Test
    public void createDentistTest(){
        Adress adress = new Adress();
        adress.setStreet("Av.Roca");
        adress.setNumber("123");
        adress.setCity("Rosario");
        adress.setState("Santa Fe");
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName("Cristiano");
        patientDTO.setLastName("Ronaldo");
        patientDTO.setEntryDate(LocalDate.parse("2010-10-10"));
        patientDTO.setDni("7777777");
        patientDTO.setAdress(adress);
        PatientDTO newPatient = patientService.create(patientDTO);
        assertNotNull(newPatient);
    }
    @Test
    public void findByIdTest(){
        Adress adress = new Adress();
        adress.setStreet("Av.Roca");
        adress.setNumber("123");
        adress.setCity("Rosario");
        adress.setState("Santa Fe");
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName("Cristiano");
        patientDTO.setLastName("Ronaldo");
        patientDTO.setEntryDate(LocalDate.parse("2010-10-10"));
        patientDTO.setDni("7777777");
        patientDTO.setAdress(adress);
        PatientDTO newPatient = patientService.create(patientDTO);
        PatientDTO patientById = patientService.findById(1);
        assertNotNull(patientById);
    }
    @Test
    public void updateDentistTest(){
        Adress adress = new Adress();
        adress.setStreet("Av.Roca");
        adress.setNumber("123");
        adress.setCity("Rosario");
        adress.setState("Santa Fe");
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName("Cristiano");
        patientDTO.setLastName("Ronaldo");
        patientDTO.setEntryDate(LocalDate.parse("2010-10-10"));
        patientDTO.setDni("7777777");
        patientDTO.setAdress(adress);
        PatientDTO newPatient = patientService.create(patientDTO);
        assertNotNull(patientService.update(patientDTO));
    }
    @Test
    public void findAllTest(){
        Adress adress = new Adress();
        adress.setStreet("Av.Roca");
        adress.setNumber("123");
        adress.setCity("Rosario");
        adress.setState("Santa Fe");
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName("Cristiano");
        patientDTO.setLastName("Ronaldo");
        patientDTO.setEntryDate(LocalDate.parse("2010-10-10"));
        patientDTO.setDni("7777777");
        patientDTO.setAdress(adress);
        PatientDTO newPatient = patientService.create(patientDTO);
        assertTrue(patientService.findAll().size()>0);
    }
    @Test
    public void deleteByIdTest(){
        Adress adress = new Adress();
        adress.setStreet("Av.Roca");
        adress.setNumber("123");
        adress.setCity("Rosario");
        adress.setState("Santa Fe");
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName("Cristiano");
        patientDTO.setLastName("Ronaldo");
        patientDTO.setEntryDate(LocalDate.parse("2010-10-10"));
        patientDTO.setDni("7777777");
        patientDTO.setAdress(adress);
        PatientDTO newPatient = patientService.create(patientDTO);
        patientService.deleteById(1);
        PatientDTO patientTest = patientService.findById(1);
        assertNull(patientTest);
    }
}
