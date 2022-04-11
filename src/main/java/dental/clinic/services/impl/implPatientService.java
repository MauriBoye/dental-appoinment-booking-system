package dental.clinic.services.impl;

import com.sun.istack.NotNull;
import dental.clinic.DTO.PatientDTO;
import dental.clinic.entities.Patient;
import dental.clinic.repository.IPatientRepository;
import dental.clinic.services.IPatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class implPatientService implements IPatientService {

    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PatientDTO findById(@NotNull Integer id) {
        Patient patient = patientRepository.getById(id);
        return mapDTO(patient);
    }

    @Override
    public PatientDTO create(@NotNull PatientDTO patientDTO) {
        Patient patient = mapEntity(patientDTO);
        Patient newPatientSave = patientRepository.save(patient);
        return mapDTO(newPatientSave);
    }

    @Override
    public void deleteById(@NotNull Integer id) {
    Patient patient = patientRepository.getById(id);
    patientRepository.delete(patient);
    }

    @Override
    public PatientDTO update(PatientDTO patientDTO) {
        Patient patient = mapEntity(patientDTO);
        Patient newPatientSave = patientRepository.save(patient);
        return mapDTO(newPatientSave);
    }

    @Override
    public List<PatientDTO> findAll() {
        List<Patient> patientList = patientRepository.findAll();
        List<PatientDTO> patientDTOList = patientList.stream().map(patient -> mapDTO(patient)).collect(Collectors.toList());
        return patientDTOList;
    }

    //----------Mapper----------
    private PatientDTO mapDTO(Patient patient){
        PatientDTO patientDTO = modelMapper.map(patient, PatientDTO.class);
        return patientDTO;
    }

    private Patient mapEntity(PatientDTO patientDTO){
        Patient patient = modelMapper.map(patientDTO, Patient.class);
        return patient;
    }
}
