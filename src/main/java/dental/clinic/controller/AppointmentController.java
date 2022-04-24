package dental.clinic.controller;

import dental.clinic.DTO.AppointmentDTO;
import dental.clinic.DTO.DentistDTO;
import dental.clinic.services.IAppointmentService;
import dental.clinic.services.IDentistService;
import dental.clinic.services.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/appointment")
public class AppointmentController {

    @Autowired
    private IAppointmentService appointmentService;

    @Autowired
    private IDentistService dentistService;

    @Autowired
    private IPatientService patientService;

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> findById(@PathVariable("id") Integer id){
        AppointmentDTO appointmentDTO = appointmentService.findById(id);
        return new ResponseEntity<>(appointmentDTO, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @CrossOrigin
    @PostMapping("/create")
    private ResponseEntity<AppointmentDTO> create(@RequestBody AppointmentDTO appointmentDTO){
        AppointmentDTO newAppointmentDTO = appointmentService.create(appointmentDTO);
        return new ResponseEntity<>(newAppointmentDTO, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    private ResponseEntity<String> deleteById(@PathVariable("id")Integer id){
        appointmentService.deleteById(id);
        return new ResponseEntity<>("Appointment deleted", HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin
    @PutMapping("/update")
    private ResponseEntity<AppointmentDTO> update(@RequestBody AppointmentDTO appointmentDTO)throws ServerException{
        if(appointmentService.findById(appointmentDTO.getId()) == null){
            throw new ServerException("Appointment not found");
        }else{
            AppointmentDTO updateAppointmentDTO = appointmentService.update(appointmentDTO);
            return new ResponseEntity<>(updateAppointmentDTO, HttpStatus.OK);
        }
    }

    @CrossOrigin
    @GetMapping("/list")
    public Collection<AppointmentDTO> findAll() {
        return appointmentService.findAll();

    }
}
