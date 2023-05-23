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




    // Add constructor and any additional methods as needed

}
