package com.tareqkhanfar.healthSystem.Service;


import com.tareqkhanfar.healthSystem.Controller.DoctorController;
import com.tareqkhanfar.healthSystem.Controller.PatientController;
import com.tareqkhanfar.healthSystem.Model.DTO.AppointmentDTO;
import com.tareqkhanfar.healthSystem.Model.DTO.DoctorDTO;
import com.tareqkhanfar.healthSystem.Model.Entity.Appointment;
import com.tareqkhanfar.healthSystem.Model.Entity.Doctor;
import com.tareqkhanfar.healthSystem.Model.Entity.Patient;
import com.tareqkhanfar.healthSystem.Model.Repository.AppoinmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppoinmentRepo appointmentRepo ;

    @Autowired
    private  PatientService patientService;
    @Autowired
    private  DoctorService doctorService;



    public AppointmentDTO getById(Integer id) {
        return toDTO(this.appointmentRepo.findById(id).get());
    }

    public List<AppointmentDTO> getAll() {

        return toDTOList(this.appointmentRepo.findAll()) ;
    }

    public AppointmentDTO saveAppointment(AppointmentDTO dto){
        Appointment appointment  = convertToEntity(dto);
        return toDTO(this.appointmentRepo.save(appointment));
    }

    public AppointmentDTO updateAppointment(Integer id, AppointmentDTO appointmentDTO) {
        Optional<Appointment> optionalAppointment = this.appointmentRepo.findById(id);
        if (optionalAppointment.isPresent()) {
            Appointment existingAppointment = optionalAppointment.get();

            // Update the fields of the existing appointment with the values from the DTO
            existingAppointment.setDate(appointmentDTO.getDate());
            existingAppointment.setPurpose(appointmentDTO.getPurpose());
            existingAppointment.setDuration(appointmentDTO.getDuration());
            existingAppointment.setIsCancelled(appointmentDTO.getIsCancelled());
            existingAppointment.setRoomNumber(appointmentDTO.getRoomNumber());
            existingAppointment.setNote(appointmentDTO.getNote());

            existingAppointment.setDoctor_id_fk(appointmentDTO.getDoctor().getId());
            existingAppointment.setPatient_id_fk(appointmentDTO.getPatient().getId());

            // Save the updated appointment entity
            return toDTO(this.appointmentRepo.save(existingAppointment));
        } else {
            throw new IllegalArgumentException("Appointment with ID " + id + " not found");
        }
    }

    public void deleteAppointment(Integer integer) {

        this.appointmentRepo.deleteById(integer) ;

    }





    public  AppointmentDTO toDTO(Appointment entity) {
        return AppointmentDTO.builder()
                .id(entity.getId())
                .date(entity.getDate())
                .purpose(entity.getPurpose())
                .duration(entity.getDuration())
                .isCancelled(entity.getIsCancelled())
                .roomNumber(entity.getRoomNumber())
                .note(entity.getNote())
                .build();

//        .doctor(doctorService.getById(entity.getDoctor_id_fk()))
    }


    public  List<AppointmentDTO> toDTOList(List<Appointment> appointmentList) {

        List<AppointmentDTO> list = new LinkedList<>() ;

        for (Appointment appointment : appointmentList) {
            list.add(toDTO(appointment)) ;
        }

        return list;
    }

    public Appointment convertToEntity(AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();
        appointment.setId(appointmentDTO.getId());
        appointment.setDate(appointmentDTO.getDate());
        appointment.setPurpose(appointmentDTO.getPurpose());
        appointment.setDuration(appointmentDTO.getDuration());
        appointment.setIsCancelled(appointmentDTO.getIsCancelled());
        appointment.setRoomNumber(appointmentDTO.getRoomNumber());
        appointment.setNote(appointmentDTO.getNote());
        appointment.setPatient_id_fk(appointmentDTO.getPatient().getId());
        appointment.setDoctor_id_fk(appointmentDTO.getDoctor().getId());

        return appointment;
    }


}
