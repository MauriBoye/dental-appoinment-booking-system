package dental.clinic.services.impl;

import com.sun.istack.NotNull;
import dental.clinic.DTO.AdressDTO;
import dental.clinic.entities.Adress;
import dental.clinic.repository.IAdressRepository;
import dental.clinic.services.IAdressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class implAdressService implements IAdressService {

    @Autowired
    private IAdressRepository adressRepository;

    @Autowired
    private ModelMapper modelMapper;

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
    public List<AdressDTO> findAll() {
        List<Adress> adressList = adressRepository.findAll();
        List<AdressDTO> adressDTOList = adressList.stream().map(adress -> mapDTO(adress)).collect(Collectors.toList());
        return adressDTOList;
    }

    //----------Mapper----------
    private AdressDTO mapDTO(Adress adress){
        AdressDTO adressDTO = modelMapper.map(adress,AdressDTO.class);
        return adressDTO;
    }

    private Adress mapEntity(AdressDTO adressDTO){
        Adress adress = modelMapper.map(adressDTO, Adress.class);
        return adress;
    }
}
