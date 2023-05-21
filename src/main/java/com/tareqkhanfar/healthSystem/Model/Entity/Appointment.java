package com.tareqkhanfar.healthSystem.Model.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Appointment")
@Data
public class Appointment {
    @Id
    @Column(name = "Appointment_id")
    private Integer id ;
    @Column(name = "Date")

    private String Date ;
    @Column(name = "purpose")

    private String purpose ;
    @Column(name = "duration")

    private Integer duration ;
    @Column(name = "is_Cancelled")

    private Boolean isCancelled ;
    @Column(name = "room_Number")

    private String roomNumber ;
    @Column(name = "note")

    private String note ;


    @Column(name = "Patient_id")
    private Integer patient_id_fk;
    @Column(name = "Doctor_id")
    private Integer doctor_id_fk;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "patient_id" , insertable = false , updatable = false)
    private Patient appintment_patient ;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "Doctor_id" , insertable = false , updatable = false)
    private Doctor appintment_doctor ;


}
