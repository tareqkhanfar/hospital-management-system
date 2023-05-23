package com.tareqkhanfar.healthSystem.Service;

import com.tareqkhanfar.healthSystem.Model.DTO.AppointmentDTO;
import com.tareqkhanfar.healthSystem.Model.DTO.MedicalRecordDTO;
import com.tareqkhanfar.healthSystem.Model.DTO.PatientDTO;
import com.tareqkhanfar.healthSystem.Model.Entity.Patient;
import com.tareqkhanfar.healthSystem.Model.Repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PatientService {


    @Autowired
    private PatientRepo patientRepo ;

    public PatientDTO getPatientByID(Integer patient_id) {
  return  toDTO(this.patientRepo.findById(patient_id).get());
    }

    public List<PatientDTO> getAllPatients() {

        return PatientService.toDTOList(this.patientRepo.findAll().stream().toList()) ;
    }

    public PatientDTO SavePatient(PatientDTO dto){
        Patient patient  = PatientService.convertToEntity(dto);
       return toDTO(this.patientRepo.save(patient));
    }

    public PatientDTO updatePatient(PatientDTO dto , Integer id){
        Patient patient  = PatientService.convertToEntity(dto);
     patient =   this.patientRepo.findById(id).get();
     patient.setId(id);
     patient.setName(dto.getName());
     patient.setAge(dto.getAge());
     patient.setGender(dto.getGender());
     patient.setAddress(dto.getAddress());
     patient.setBloodType(dto.getBloodType());
     patient.setEmergencyContact(dto.getEmergencyContact());
     patient.setMedicalHistory(dto.getMedicalHistory());
     patient.setAllergies(dto.getAllergies());
        return toDTO(this.patientRepo.save(patient));
    }

    public void deletePatient(Integer integer) {

           this.patientRepo.deleteById(integer) ;

    }


    private static Patient convertToEntity(PatientDTO patientDTO) {
        Patient patient = new Patient();
        // Set the attributes from the DTO to the entity
        patient.setId(patientDTO.getId());
        patient.setName(patientDTO.getName());
        patient.setPhone(patientDTO.getPhone());
        patient.setAge(patientDTO.getAge());
        patient.setAddress(patientDTO.getAddress());
        patient.setEmail(patientDTO.getEmail());
        patient.setGender(patientDTO.getGender());
        patient.setMedicalHistory(patientDTO.getMedicalHistory());
        patient.setAllergies(patientDTO.getAllergies());
        patient.setOngoingTreatments(patientDTO.getOngoingTreatments());
        patient.setBloodType(patientDTO.getBloodType());
        patient.setEmergencyContact(patientDTO.getEmergencyContact());

        // Set any additional attributes if needed

        return patient;
    }

    private static PatientDTO toDTO(Patient entity) {
        return PatientDTO.builder()
                .patient_id(entity.getId())
                .name(entity.getName())
                .phone(entity.getPhone())
                .age(entity.getAge())
                .address(entity.getAddress())
                .email(entity.getEmail())
                .gender(entity.getGender())
                .medicalHistory(entity.getMedicalHistory())
                .allergies(entity.getAllergies())
                .ongoingTreatments(entity.getOngoingTreatments())
                .bloodType(entity.getBloodType())
                .emergencyContact(entity.getEmergencyContact())
                .medicalRecords(MedicalService.toDTOList(entity.getMedicalRecords()))
                .appointmentList(AppointmentService.toDTOList(entity.getAppointmentList()))
                .build();
    }

    private static List<PatientDTO> toDTOList (List<Patient> enities) {
        List<PatientDTO> list = new LinkedList<>() ;
        for (Patient patient : enities) {
            list.add(PatientService.toDTO(patient));
        }
        return list ;
    }
}
