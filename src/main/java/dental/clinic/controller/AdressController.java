package dental.clinic.controller;

import dental.clinic.DTO.AdressDTO;
import dental.clinic.DTO.DentistDTO;
import dental.clinic.entities.Adress;
import dental.clinic.services.IAdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;

@RestController
@RequestMapping("api/adress")
public class AdressController {

    @Autowired
    private IAdressService adressService;

    @GetMapping("/{id}")
    public ResponseEntity<AdressDTO> findById(@PathVariable("id") Integer id){
        AdressDTO adressDTO = adressService.findById(id);
        return new ResponseEntity<>(adressDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<AdressDTO> create(@RequestBody AdressDTO adressDTO){
        AdressDTO newAdressDTO = adressService.create(adressDTO);
        return new ResponseEntity<>(newAdressDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id){
        adressService.deleteById(id);
        return new ResponseEntity<>("Adress deleted", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<AdressDTO> update(@RequestBody AdressDTO adressDTO)throws ServerException{
        if(adressService.findById(adressDTO.getId()) == null){
            throw new ServerException("Adress not found");
        }else{
            AdressDTO updateAdressDTO = adressService.update(adressDTO);
            return new ResponseEntity<>(updateAdressDTO, HttpStatus.OK);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<AdressDTO>> findAll(){
        List<AdressDTO> adressDTOList = adressService.findAll();
        return new ResponseEntity<>(adressDTOList, HttpStatus.OK);
    }
}
