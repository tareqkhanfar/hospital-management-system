package com.tareqkhanfar.healthSystem.Model.Entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Patient")
@Setter
@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString
public class Patient extends Person{
    @Id
    @Column(name = "patient_id")
    private Integer id ;
    @Column(name = "medical_History")
    private String medicalHistory ;
    @Column(name = "allergies")

    private String allergies ;
    @Column(name = "ongoing_Treatments")

    private String ongoingTreatments ;
    @Column(name = "blood_Type")

    private String bloodType ;
    @Column(name = "emergency_Contact")
    private String emergencyContact ;


    ////////////////////////////////////////////////////
    @JsonManagedReference
    @OneToMany(mappedBy = "patient")
    private List<MedicalRecord> MedicalRecords ;

    @JsonManagedReference
    @OneToMany(mappedBy = "appintment_patient")
    private List<Appointment> appointmentList ;

}
