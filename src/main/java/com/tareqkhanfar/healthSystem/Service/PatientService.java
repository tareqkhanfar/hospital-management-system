package com.tareqkhanfar.healthSystem.Service;

import com.tareqkhanfar.healthSystem.Model.Entity.Patient;
import com.tareqkhanfar.healthSystem.Model.Repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {


    @Autowired
    private PatientRepo patientRepo ;

    public Patient getPatientByID(Integer id) {

       if (  this.patientRepo.findById(id).isPresent()  )
           return  this.patientRepo.findById(id).get();

    return  new Patient();
    }
}
