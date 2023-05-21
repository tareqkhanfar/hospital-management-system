package com.tareqkhanfar.healthSystem.Service;

import com.tareqkhanfar.healthSystem.Model.DTO.PatientDTO;
import com.tareqkhanfar.healthSystem.Model.Entity.Patient;
import com.tareqkhanfar.healthSystem.Model.Repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {


    @Autowired
    private PatientRepo patientRepo ;

    public PatientDTO getPatientByID(Integer patient_id) {
   return  PatientDTO.toDTO(this.patientRepo.findById(patient_id).get());
    }

    public List<PatientDTO> getAllPatients() {

        return PatientDTO.toDTOList( this.patientRepo.findAll().stream().toList()) ;
    }

}
