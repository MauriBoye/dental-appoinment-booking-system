package dental.clinic.services.impl;

import com.sun.istack.NotNull;
import dental.clinic.DTO.DentistDTO;
import dental.clinic.entities.Dentist;
import dental.clinic.repository.IDentistRepository;
import dental.clinic.services.IDentistService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service //Metodos y logica
public class implDentistService implements IDentistService {

    @Autowired //Inyectar repositorio
    private IDentistRepository dentistRepository; //Traigo los metodos de repositorio(CRUD)

    @Autowired
    private ModelMapper modelMapper; //Herramienta para pasar de entidad a DTO

    @Override
    public DentistDTO findById(@NotNull Integer id) {
        Dentist dentist = dentistRepository.getById(id); //La DB trabaja con entidades, pasarlo a DTO
        return mapDTO(dentist); //El metodo requiere DTO
    }

    @Override
    public DentistDTO create(@NotNull DentistDTO dentistDTO) {
        //1- DTO convertirlo en entidad
        Dentist dentist = mapEntity(dentistDTO);
        //2- Guardar entidad en DB
        Dentist newDentistSave = dentistRepository.save(dentist);
        //3- Retornar entidad de DB como DTO
        return mapDTO(newDentistSave);
    }

    @Override
    public void deleteById(@NotNull Integer id) {
        //1- Buscar entidad
        Dentist dentist = dentistRepository.getById(id);
        //2- Verificar que se encontro

        //3- Si se encontro eliminarla
        dentistRepository.delete(dentist);

    }

    @Override
    public DentistDTO update(DentistDTO dentistDTO) {
        //Mandamos ID, si el ID existe el metodo save lo actualiza
        //1- DTO convertirlo en entidad
        Dentist dentist = mapEntity(dentistDTO);
        //2- Guardar entidad en DB
        Dentist newDentistSave = dentistRepository.save(dentist);
        //3- Retornar entidad de DB como DTO
        return mapDTO(newDentistSave);
    }

    @Override
    public List<DentistDTO> findAll() {
        //Recibe una lista
        List<Dentist> dentistList = dentistRepository.findAll();
        //Pasar la lista de entidades a dto, 1ro stream.map (stream para usar .map) para recorrer, luego mapDTO para pasar de entidad a dto y 3ro collect lo guarda en una lista
        List<DentistDTO> dentistDTOList = dentistList.stream().map(dentist -> mapDTO(dentist)).collect(Collectors.toList());
        //Retornar lista DTO
        return dentistDTOList;
    }

    //----------Mapper-----------
    private DentistDTO mapDTO(Dentist dentist){ //Herramienta para pasar de entidad a DTO
        DentistDTO dentistDTO = modelMapper.map(dentist, DentistDTO.class); //1er parametro la entidad pasada por parametro, 2do a que la quiero convertir (DTO)
        return dentistDTO; //Devolvemos DTO
    }

    private Dentist mapEntity(DentistDTO dentistDTO){ //Herramienta para pasar de DTO a entidad
        Dentist dentist = modelMapper.map(dentistDTO, Dentist.class);//1er parametro el DTO pasada por parametro, 2do a que la quiero convertir (entidad)
        return dentist; //Retorna una entidad
    }

}
