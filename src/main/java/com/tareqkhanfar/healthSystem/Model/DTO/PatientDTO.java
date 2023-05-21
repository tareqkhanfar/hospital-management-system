package com.tareqkhanfar.healthSystem.Model.DTO;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tareqkhanfar.healthSystem.Model.Entity.Patient;
import lombok.Builder;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data

public class PatientDTO extends PersonDTO {
    private String medicalHistory;
    private String allergies;
    private String ongoingTreatments;
    private String bloodType;
    private String emergencyContact;

    @JsonManagedReference
    private List<MedicalRecordDTO> medicalRecords;

    @JsonManagedReference
    private List<AppointmentDTO> appointmentList;

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
        this.medicalRecords = medicalRecords;
        this.appointmentList = appointmentList;
    }

    public static PatientDTO toDTO(Patient entity) {
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
                .medicalRecords(MedicalRecordDTO.toDTOList(entity.getMedicalRecords()))
                .appointmentList(AppointmentDTO.toDTOList(entity.getAppointmentList()))
                .build();
    }
    public static List<PatientDTO> toDTOList (List<Patient> enities) {
        List<PatientDTO> list = new LinkedList<>() ;
        for (Patient patient : enities) {
            list.add(PatientDTO.toDTO(patient));
        }
        return list ;
    }
}
