package dental.clinic.controller;

import dental.clinic.DTO.DentistDTO;
import dental.clinic.services.IDentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //
@RequestMapping("api/dentist") //Especificar ruta
public class DentistController {

    @Autowired //Inyectar service, traer metodos
    private IDentistService dentistService;

    @GetMapping("/{id}") //Del tipo get para consultar datos, por parametro le pasamos id
    public ResponseEntity<DentistDTO> findById(@PathVariable("id") Integer id){
        //ResponseEntity agrego el tipo de dato que me devuelve y al lado el codigo de estado que me da la peticion
        //PathVariable le pasamos el mismo nombre del parametro y le agregamos el tipo, para matchear con la url que le paso en la peticion
        DentistDTO dentistDTO = dentistService.findById(id);
        return new ResponseEntity<>(dentistDTO, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<DentistDTO> create(@RequestBody DentistDTO dentistDTO){
        //Request body, le mandamos un cuerpo en la peticion
        DentistDTO newDentistDTO = dentistService.create(dentistDTO);
        return new ResponseEntity<>(newDentistDTO, HttpStatus.OK);
    }

}
