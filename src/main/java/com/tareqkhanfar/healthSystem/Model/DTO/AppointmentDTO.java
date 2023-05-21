package com.tareqkhanfar.healthSystem.Model.DTO;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tareqkhanfar.healthSystem.Model.Entity.Appointment;
import lombok.Builder;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
@Builder
public class AppointmentDTO {

    private Integer id;
    private String date;
    private String purpose;
    private Integer duration;
    private Boolean isCancelled;
    private String roomNumber;
    private String note;

    // Add any additional fields as needed

    @JsonManagedReference
    private DoctorDTO doctor;

    @JsonManagedReference
    private PatientDTO patient;

    public static List<AppointmentDTO> toDTOList(List<Appointment> appointmentList) {

        List<AppointmentDTO> list = new LinkedList<>() ;

        for (Appointment appointment : appointmentList) {
            list.add(AppointmentDTO.toDTO(appointment)) ;
        }
        return list;
    }


    // Add constructor and any additional methods as needed
    public static AppointmentDTO toDTO(Appointment entity) {
        return AppointmentDTO.builder()
                .id(entity.getId())
                .date(entity.getDate())
                .purpose(entity.getPurpose())
                .duration(entity.getDuration())
                .isCancelled(entity.getIsCancelled())
                .roomNumber(entity.getRoomNumber())
                .note(entity.getNote())
                .build();
    }

}
