package com.tareqkhanfar.healthSystem.Controller;

import com.tareqkhanfar.healthSystem.Model.DTO.PatientDTO;
import com.tareqkhanfar.healthSystem.Model.Entity.Patient;
import com.tareqkhanfar.healthSystem.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @GetMapping("/getPatientBYid")
    public PatientDTO getPatientByID (@RequestParam  Integer id){
      return this.patientService.getPatientByID(id);
    }
    @GetMapping("/getAllPatients")
    public List<PatientDTO> getPatientByID (){
        return this.patientService.getAllPatients();
    }
}
