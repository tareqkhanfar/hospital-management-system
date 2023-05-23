package com.tareqkhanfar.healthSystem.Service;

import com.tareqkhanfar.healthSystem.Model.DTO.MedicalRecordDTO;
import com.tareqkhanfar.healthSystem.Model.Entity.MedicalRecord;
import com.tareqkhanfar.healthSystem.Model.Repository.MedicalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class MedicalService {

    @Autowired
    private MedicalRepo medicalRepo ;




    private static MedicalRecordDTO toDTO(MedicalRecord entity) {
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
    public static List<MedicalRecordDTO> toDTOList(List<MedicalRecord> medicalRecords) {
        List<MedicalRecordDTO> list = new LinkedList<>() ;
        for (MedicalRecord medicalRecord : medicalRecords) {
            list.add(toDTO(medicalRecord));
        }

        return list ;
    }



}
