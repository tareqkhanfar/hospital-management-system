package com.tareqkhanfar.healthSystem.Controller;

import com.tareqkhanfar.healthSystem.Model.Entity.Patient;
import com.tareqkhanfar.healthSystem.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;
    @GetMapping("/getPatient")
    public Patient getPatientByID (@RequestParam  Integer id){
      return this.patientService.getPatientByID(id);
    }
}
