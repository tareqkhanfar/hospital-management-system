package com.tareqkhanfar.healthSystem.Model.DTO;

import com.tareqkhanfar.healthSystem.Model.DTO.AppointmentDTO;
import com.tareqkhanfar.healthSystem.Model.DTO.MedicalRecordDTO;
import com.tareqkhanfar.healthSystem.Model.DTO.PersonDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO  extends PersonDTO {
    private String medicalHistory;
    private String allergies;
    private String ongoingTreatments;
    private String bloodType;
    private String emergencyContact;

//    private List<MedicalRecordDTO> medicalRecords;
//    private List<AppointmentDTO> appointmentList;

    @Builder
    public PatientDTO(Integer patient_id , String name, String phone, Byte age, String address, String email, String gender,
                      String medicalHistory, String allergies, String ongoingTreatments, String bloodType,
                      String emergencyContact
                      ) {
        super(patient_id , name, phone, age, address, email, gender);
        this.medicalHistory = medicalHistory;
        this.allergies = allergies;
        this.ongoingTreatments = ongoingTreatments;
        this.bloodType = bloodType;
        this.emergencyContact = emergencyContact;
//        this.medicalRecords = medicalRecords;
//        this.appointmentList = appointmentList;
    }

    // Getters and setters (omitted for brevity)
}
