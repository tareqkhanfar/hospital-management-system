package com.tareqkhanfar.healthSystem.Service;


import com.tareqkhanfar.healthSystem.Model.DTO.AppointmentDTO;
import com.tareqkhanfar.healthSystem.Model.DTO.DoctorDTO;
import com.tareqkhanfar.healthSystem.Model.DTO.PatientDTO;
import com.tareqkhanfar.healthSystem.Model.Entity.Doctor;
import com.tareqkhanfar.healthSystem.Model.Entity.Patient;
import com.tareqkhanfar.healthSystem.Model.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


@Service
public class DoctorService {


    @Autowired
    private DoctorRepository doctorRepository;


    public DoctorDTO getById(Integer id) {
        return toDTO(doctorRepository.findById(id).get());
    }

    public List<DoctorDTO> getAll() {

        return toDTOList(this.doctorRepository.findAll().stream().toList()) ;
    }

    public DoctorDTO SavePatient(DoctorDTO dto){
        Doctor patient  = convertToEntity(dto);
        return toDTO(this.doctorRepository.save(patient));
    }

    public DoctorDTO updateDoctor(Integer id, DoctorDTO doctorDTO) {
        Optional<Doctor> optionalDoctor = this.doctorRepository.findById(id);
        if (optionalDoctor.isPresent()) {
            Doctor existingDoctor = optionalDoctor.get();

            // Update the fields of the existing doctor with the values from the DTO
            existingDoctor.setName(doctorDTO.getName());
            existingDoctor.setPhone(doctorDTO.getPhone());
            existingDoctor.setAge(doctorDTO.getAge());
            existingDoctor.setAddress(doctorDTO.getAddress());
            existingDoctor.setEmail(doctorDTO.getEmail());
            existingDoctor.setGender(doctorDTO.getGender());
            existingDoctor.setSpecialization(doctorDTO.getSpecialization());
            existingDoctor.setQualifications(doctorDTO.getQualifications());
            existingDoctor.setAvaliability(doctorDTO.getAvailability());
            existingDoctor.setSalary(doctorDTO.getSalary());
            existingDoctor.setIsActive(doctorDTO.getIsActive());
            // Set any additional fields as needed
            // Save the updated doctor entity
            return toDTO(doctorRepository.save(existingDoctor));
        } else {
            throw new IllegalArgumentException("Doctor with ID " + id + " not found");
        }
    }

    public void deleteDoctor(Integer integer) {

        this.doctorRepository.deleteById(integer) ;

    }



    private static List<DoctorDTO> toDTOList(List<Doctor> enities) {
        List<DoctorDTO> list = new LinkedList<>();
        for (Doctor patient : enities) {
            list.add(toDTO(patient));
        }
        return list;
    }


    private static DoctorDTO toDTO(Doctor entity) {
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
                .appointmentList(AppointmentService.toDTOList(entity.getAppointmentList()))
                .build();
    }



    public static Doctor convertToEntity(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor();
        doctor.setId(doctorDTO.getId());
        doctor.setName(doctorDTO.getName());
        doctor.setPhone(doctorDTO.getPhone());
        doctor.setAge(doctorDTO.getAge());
        doctor.setAddress(doctorDTO.getAddress());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setGender(doctorDTO.getGender());
        doctor.setSpecialization(doctorDTO.getSpecialization());
        doctor.setQualifications(doctorDTO.getQualifications());
        doctor.setAvaliability(doctorDTO.getAvailability());
        doctor.setSalary(doctorDTO.getSalary());
        doctor.setIsActive(doctorDTO.getIsActive());
        // Set any additional fields as needed

        return doctor;
    }



}