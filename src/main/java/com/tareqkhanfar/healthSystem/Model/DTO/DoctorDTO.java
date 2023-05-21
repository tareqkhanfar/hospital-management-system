package com.tareqkhanfar.healthSystem.Model.DTO;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tareqkhanfar.healthSystem.Model.Entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO extends PersonDTO {

    private String specialization;
    private String qualifications;
    private String availability;
    private Double salary;
    private Boolean isActive;

    // Add any additional fields as needed

    @JsonManagedReference
    private List<AppointmentDTO> appointmentList;

    @Builder
    public DoctorDTO(Integer doctor_id, String name, String phone, Byte age, String address, String email, String gender, String specialization, String qualifications, String availability, Double salary, Boolean isActive, List<AppointmentDTO> appointmentList) {
        super(doctor_id, name, phone, age, address, email, gender);
        this.specialization = specialization;
        this.qualifications = qualifications;
        this.availability = availability;
        this.salary = salary;
        this.isActive = isActive;
        this.appointmentList = appointmentList;
    }

    // Add constructor and any additional methods as needed
    public static DoctorDTO toDTO(Doctor entity) {
        return DoctorDTO.builder()
                .doctor_id(entity.getId())
                .name(entity.getName())
                .phone(entity.getPhone())
                .age(entity.getAge())
                .address(entity.getAddress())
                .email(entity.getEmail())
                .gender(entity.getGender())
                .specialization(entity.getSpecialization())
                .qualifications(entity.getQualifications())
                .availability(entity.getAvaliability())
                .salary(entity.getSalary())
                .isActive(entity.getIsActive())
                .appointmentList(AppointmentDTO.toDTOList(entity.getAppointmentList()))
                .build();
    }

}
