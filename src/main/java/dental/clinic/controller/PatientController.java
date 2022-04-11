package dental.clinic.controller;

import dental.clinic.DTO.DentistDTO;
import dental.clinic.DTO.PatientDTO;
import dental.clinic.services.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;

@RestController
@RequestMapping("api/patient")
public class PatientController {

    @Autowired
    private IPatientService patientService;

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> findById(@PathVariable("id") Integer id){
        PatientDTO patientDTO = patientService.findById(id);
        return new ResponseEntity<>(patientDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<PatientDTO> create(@RequestBody PatientDTO patientDTO){
        PatientDTO newPatientDTO = patientService.create(patientDTO);
        return new ResponseEntity<>(newPatientDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id){
        patientService.deleteById(id);
        return new ResponseEntity<>("Patient deleted", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<PatientDTO> update(@RequestBody PatientDTO patientDTO)throws ServerException{
        if(patientService.findById(patientDTO.getId()) == null){
            throw new ServerException("Patient not found");
        }else{
            PatientDTO updatePatientDTO = patientService.update(patientDTO);
            return new ResponseEntity<>(updatePatientDTO, HttpStatus.OK);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<PatientDTO>> findAll(){
        List<PatientDTO> patientDTOList = patientService.findAll();
        return new ResponseEntity<>(patientDTOList,HttpStatus.OK);
    }
}
