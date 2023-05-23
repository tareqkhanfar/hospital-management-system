package com.tareqkhanfar.healthSystem.Service;

import com.tareqkhanfar.healthSystem.Model.DTO.AppointmentDTO;
import com.tareqkhanfar.healthSystem.Model.DTO.MedicalRecordDTO;
import com.tareqkhanfar.healthSystem.Model.Entity.Appointment;
import com.tareqkhanfar.healthSystem.Model.Entity.MedicalRecord;
import com.tareqkhanfar.healthSystem.Model.Entity.Patient;
import com.tareqkhanfar.healthSystem.Model.Repository.MedicalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class MedicalService {

    @Autowired
    private MedicalRepo medicalRepo ;


    public MedicalRecordDTO getById(Integer id) {
        return toDTO(this.medicalRepo.findById(id).get());
    }

    public List<MedicalRecordDTO> getAll() {

        return toDTOList(this.medicalRepo.findAll().stream().toList()) ;
    }

    public MedicalRecordDTO saveAppointment(MedicalRecordDTO dto){
        MedicalRecord medicalRecorde  = converToEntity(dto);
        return toDTO(this.medicalRepo.save(medicalRecorde));
    }


    public MedicalRecord updateMedicalRecord(Integer recordId, MedicalRecordDTO medicalRecordDTO) {
        Optional<MedicalRecord> optionalMedicalRecord = this.medicalRepo.findById(recordId);
        if (optionalMedicalRecord.isPresent()) {
            MedicalRecord existingMedicalRecord = optionalMedicalRecord.get();

            // Update the fields of the existing medical record with the values from the DTO
            existingMedicalRecord.setMedications(medicalRecordDTO.getMedications());
            existingMedicalRecord.setLabResult(medicalRecordDTO.getLabResult());
            existingMedicalRecord.setDiagnosis(medicalRecordDTO.getDiagnosis());
            existingMedicalRecord.setVisitDate(medicalRecordDTO.getVisitDate());
            existingMedicalRecord.setCreatedBY(medicalRecordDTO.getCreatedBy());
            existingMedicalRecord.setSymptoms(medicalRecordDTO.getSymptoms());
            existingMedicalRecord.setTreamtmentPlan(medicalRecordDTO.getTreatmentPlan());
            existingMedicalRecord.setNextAppoinment(medicalRecordDTO.getNextAppointment());

            // Retrieve the associated patient entity using its ID

            // Set the association between the medical record and the patient
            existingMedicalRecord.setPatient_id_fk(medicalRecordDTO.getPatient_id());
            // Save the updated medical record entity
            return this.medicalRepo.save(existingMedicalRecord);
        } else {
            throw new IllegalArgumentException("Medical record with ID " + recordId + " not found");
        }
    }

    public void deleteMedicalRecord(Integer integer) {

        this.medicalRepo.deleteById(integer) ;

    }




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
        if (medicalRecords == null){
            return null ;
        }
        for (MedicalRecord medicalRecord : medicalRecords) {
            list.add(toDTO(medicalRecord));
        }
        System.out.println("hello "+list.toString());

        return list ;
    }

    public MedicalRecord converToEntity(MedicalRecordDTO medicalRecordDTO) {
        MedicalRecord medicalRecord = new MedicalRecord();

        medicalRecord.setRecordId(medicalRecordDTO.getRecordId());
        medicalRecord.setMedications(medicalRecordDTO.getMedications());
        medicalRecord.setLabResult(medicalRecordDTO.getLabResult());
        medicalRecord.setDiagnosis(medicalRecordDTO.getDiagnosis());
        medicalRecord.setVisitDate(medicalRecordDTO.getVisitDate());
        medicalRecord.setCreatedBY(medicalRecordDTO.getCreatedBy());
        medicalRecord.setSymptoms(medicalRecordDTO.getSymptoms());
        medicalRecord.setTreamtmentPlan(medicalRecordDTO.getTreatmentPlan());
        medicalRecord.setNextAppoinment(medicalRecordDTO.getNextAppointment());

        // Retrieve the associated patient entity using its ID
       // Patient patient = patientService.getPatientById(medicalRecordDTO.getPatient().getId());

        // Set the association between the medical record and the patient
      //  medicalRecord.setPatient(patient);
        medicalRecord.setPatient_id_fk(medicalRecordDTO.getPatient_id());

        return medicalRecord;
    }

}
