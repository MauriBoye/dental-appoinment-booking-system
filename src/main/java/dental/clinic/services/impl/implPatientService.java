package dental.clinic.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sun.istack.NotNull;
import dental.clinic.DTO.AppointmentDTO;
import dental.clinic.DTO.PatientDTO;
import dental.clinic.entities.Appointment;
import dental.clinic.entities.Patient;
import dental.clinic.repository.IPatientRepository;
import dental.clinic.services.IPatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class implPatientService implements IPatientService {

    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    private ObjectMapper objectMapper;

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
    public Set<PatientDTO> findAll() {
        List<Patient> patientList = patientRepository.findAll();
        Set<PatientDTO> patientDTOSet = new HashSet<>();
        for (Patient patient : patientList) {
            patientDTOSet.add(mapDTO(patient));
        }
        return patientDTOSet;
    }

    //----------Mapper----------
    private PatientDTO mapDTO(Patient patient){
        PatientDTO patientDTO = objectMapper.convertValue(patient, PatientDTO.class);
        return patientDTO;
    }

    private Patient mapEntity(PatientDTO patientDTO){
        Patient patient = objectMapper.convertValue(patientDTO, Patient.class);
        return patient;
    }
}
