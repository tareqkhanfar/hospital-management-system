package com.tareqkhanfar.healthSystem.Service;


import com.tareqkhanfar.healthSystem.Model.DTO.AppointmentDTO;
import com.tareqkhanfar.healthSystem.Model.Entity.Appointment;
import com.tareqkhanfar.healthSystem.Model.Repository.AppoinmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppoinmentRepo appoinmentRepo ;


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


    public static List<AppointmentDTO> toDTOList(List<Appointment> appointmentList) {

        List<AppointmentDTO> list = new LinkedList<>() ;

        for (Appointment appointment : appointmentList) {
            list.add(toDTO(appointment)) ;
        }
        return list;
    }

}
