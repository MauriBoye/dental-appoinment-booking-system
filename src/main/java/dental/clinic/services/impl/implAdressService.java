package dental.clinic.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sun.istack.NotNull;
import dental.clinic.DTO.AdressDTO;
import dental.clinic.entities.Adress;
import dental.clinic.repository.IAdressRepository;
import dental.clinic.services.IAdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class implAdressService implements IAdressService {

    @Autowired
    private IAdressRepository adressRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public AdressDTO findById(@NotNull Integer id) {
        Adress adress = adressRepository.getById(id);
        return mapDTO(adress);
    }

    @Override
    public AdressDTO create(@NotNull AdressDTO adressDTO) {
        Adress adress = mapEntity(adressDTO);
        Adress newAdressSave = adressRepository.save(adress);
        return mapDTO(newAdressSave);
    }

    @Override
    public void deleteById(@NotNull Integer id) {
        Adress adress = adressRepository.getById(id);
        adressRepository.delete(adress);
    }

    @Override
    public AdressDTO update(AdressDTO adressDTO) {
        Adress adress = mapEntity(adressDTO);
        Adress newAdressSave = adressRepository.save(adress);
        return mapDTO(newAdressSave);
    }

    @Override
    public Set<AdressDTO> findAll() {
        List<Adress> adressList = adressRepository.findAll();
        Set<AdressDTO> adressDTOSet = new HashSet<>();
        for (Adress adress : adressList) {
            adressDTOSet.add(mapDTO(adress));
        }
        return adressDTOSet;

    }

    //----------Mapper----------
    private AdressDTO mapDTO(Adress adress){
        AdressDTO adressDTO = objectMapper.convertValue(adress,AdressDTO.class);
        return adressDTO;
    }

    private Adress mapEntity(AdressDTO adressDTO){
        Adress adress = objectMapper.convertValue(adressDTO, Adress.class);
        return adress;
    }
}
