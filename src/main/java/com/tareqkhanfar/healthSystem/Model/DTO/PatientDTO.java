package com.tareqkhanfar.healthSystem.Model.DTO;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tareqkhanfar.healthSystem.Model.Entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PatientDTO extends PersonDTO {
    private String medicalHistory;
    private String allergies;
    private String ongoingTreatments;
    private String bloodType;
    private String emergencyContact;

    @Builder
    public PatientDTO(Integer patient_id , String name, String phone, Byte age, String address, String email, String gender,
                      String medicalHistory, String allergies, String ongoingTreatments, String bloodType,
                      String emergencyContact, List<MedicalRecordDTO> medicalRecords,
                      List<AppointmentDTO> appointmentList) {


        super(patient_id , name, phone, age, address, email, gender);
        this.medicalHistory = medicalHistory;
        this.allergies = allergies;
        this.ongoingTreatments = ongoingTreatments;
        this.bloodType = bloodType;
        this.emergencyContact = emergencyContact;
       // this.medicalRecords = medicalRecords;
      //  this.appointmentList = appointmentList;
    }





}
