package dental.clinic.controller;

import dental.clinic.DTO.DentistDTO;
import dental.clinic.DTO.PatientDTO;
import dental.clinic.services.IDentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.Collection;
import java.util.List;

@RestController //
@RequestMapping("api/dentist") //Especificar ruta
public class DentistController {

    @Autowired //Inyectar service, traer metodos
    private IDentistService dentistService;

    @CrossOrigin
    @GetMapping("/{id}") //Del tipo get para consultar datos, por parametro le pasamos id
    public ResponseEntity<DentistDTO> findById(@PathVariable("id") Integer id){
        //ResponseEntity agrego el tipo de dato que me devuelve y al lado el codigo de estado que me da la peticion
        //PathVariable le pasamos el mismo nombre del parametro y le agregamos el tipo, para matchear con la url que le paso en la peticion
        DentistDTO dentistDTO = dentistService.findById(id);
        return new ResponseEntity<>(dentistDTO, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<DentistDTO> create(@RequestBody DentistDTO dentistDTO){
        //Request body, le mandamos un cuerpo en la peticion
        DentistDTO newDentistDTO = dentistService.create(dentistDTO);
        return new ResponseEntity<>(newDentistDTO, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id){
        dentistService.deleteById(id);
        return new ResponseEntity<>("Dentist deleted",HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin
    @PutMapping("/update")
    public ResponseEntity<DentistDTO> update(@RequestBody DentistDTO dentistDTO)throws ServerException{
        if(dentistService.findById(dentistDTO.getId()) == null){
            throw new ServerException("Dentist not found");
        }else{
            DentistDTO updateDentistDTO = dentistService.update(dentistDTO);
            return new ResponseEntity<>(updateDentistDTO, HttpStatus.OK);
        }
    }

    @CrossOrigin
    @GetMapping("/list")
    public Collection<DentistDTO> findAll() {
        return dentistService.findAll();

    }
}
