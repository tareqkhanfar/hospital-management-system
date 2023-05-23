package com.tareqkhanfar.healthSystem.Model.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tareqkhanfar.healthSystem.Model.Entity.Appointment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {

    private Integer id;
    private String date;
    private String purpose;
    private Integer duration;
    private Boolean isCancelled;
    private String roomNumber;
    private String note;
    private  Integer patient_id ;
    private Integer doctor_id ;

    // Add any additional fields as needed



    // Add constructor and any additional methods as needed

}
