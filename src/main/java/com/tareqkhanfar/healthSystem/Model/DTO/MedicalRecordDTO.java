package com.tareqkhanfar.healthSystem.Model.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tareqkhanfar.healthSystem.Model.Entity.MedicalRecord;
import lombok.Builder;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
@Builder
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

    @JsonBackReference
    private PatientDTO patient;

    public static List<MedicalRecordDTO> toDTOList(List<MedicalRecord> medicalRecords) {
   List<MedicalRecordDTO> list = new LinkedList<>() ;
   for (MedicalRecord medicalRecord : medicalRecords) {
       list.add(MedicalRecordDTO.toDTO(medicalRecord));
   }

   return list ;
    }
    public static MedicalRecordDTO toDTO(MedicalRecord entity) {
        return MedicalRecordDTO.builder()
                .recordId(entity.getRecordId())
                .medications(entity.getMedications())
                .labResult(entity.getLabResult())
                .diagnosis(entity.getDiagnosis())
                .visitDate(entity.getVisitDate())
                .createdBy(entity.getCreatedBY())
                .symptoms(entity.getSymptoms())
                .treatmentPlan(entity.getTreamtmentPlan())
                .nextAppointment(entity.getNextAppoinment())
                .build();
    }


    // Add constructor and any additional methods as needed

}
