package dental.clinic.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sun.istack.NotNull;
import dental.clinic.DTO.AppointmentDTO;
import dental.clinic.entities.Appointment;
import dental.clinic.repository.IAppointmentRepository;
import dental.clinic.services.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class implAppointmentService implements IAppointmentService {

    @Autowired
    private IAppointmentRepository appointmentRepository;

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public AppointmentDTO findById(Integer id) {
        Appointment appointment = appointmentRepository.getById(id);
        return mapDTO(appointment);
    }

    @Override
    public AppointmentDTO create(@NotNull AppointmentDTO appointmentDTO) {
        Appointment appointment = mapEntity(appointmentDTO);
        Appointment newAppointment = appointmentRepository.save(appointment);
        return mapDTO(newAppointment);
    }

    @Override
    public void deleteById(@NotNull Integer id) {
        Appointment appointment = appointmentRepository.getById(id);
        appointmentRepository.delete(appointment);
    }

    @Override
    public AppointmentDTO update(AppointmentDTO appointmentDTO) {
        Appointment appointment = mapEntity(appointmentDTO);
        Appointment newAppointment = appointmentRepository.save(appointment);
        return mapDTO(newAppointment);
    }

    @Override
    public Set<AppointmentDTO> findAll() {
        List<Appointment> appointmentList = appointmentRepository.findAll();
        Set<AppointmentDTO> appointmentDTOSet = new HashSet<>();
        for (Appointment appointment : appointmentList) {
            appointmentDTOSet.add(mapDTO(appointment));
        }
        return appointmentDTOSet;
    }

    //----------Mapper object-----------
    private AppointmentDTO mapDTO(Appointment appointment){
        AppointmentDTO appointmentDTO = objectMapper.convertValue(appointment, AppointmentDTO.class);
        return appointmentDTO;
    }

    protected Appointment mapEntity(AppointmentDTO appointmentDTO){
        Appointment appointment = objectMapper.convertValue(appointmentDTO, Appointment.class);
        return appointment;
    }

}
