package com.tareqkhanfar.healthSystem.Model.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tareqkhanfar.healthSystem.Model.Entity.MedicalRecord;
import com.tareqkhanfar.healthSystem.Model.Entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
public class MedicalRecordDTO {

    private Integer recordId;
    private String medications;
    private String labResult;
    private String diagnosis;
    private String visitDate;
    private String createdBy;
    private String symptoms;
    private String treatmentPlan;
    private String nextAppointment;

    // Add any additional fields as needed

   private Integer patient_id ;
@Builder
    public MedicalRecordDTO(Integer recordId, String medications, String labResult, String diagnosis, String visitDate, String createdBy, String symptoms, String treatmentPlan, String nextAppointment, Integer patientId) {
        // Initialize the fields with the provided values
        this.recordId = recordId;
        this.medications = medications;
        this.labResult = labResult;
        this.diagnosis = diagnosis;
        this.visitDate = visitDate;
        this.createdBy = createdBy;
        this.symptoms = symptoms;
        this.treatmentPlan = treatmentPlan;
        this.nextAppointment = nextAppointment;
        this.patient_id = patientId;
    }




    // Add constructor and any additional methods as needed

}
