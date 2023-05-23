package com.tareqkhanfar.healthSystem.Controller;

import com.tareqkhanfar.healthSystem.Model.DTO.PatientDTO;
import com.tareqkhanfar.healthSystem.Model.Entity.Patient;
import com.tareqkhanfar.healthSystem.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @GetMapping("/getByID/{id}")
    public PatientDTO getPatientByID (@PathVariable(name = "id")  Integer id){
      return this.patientService.getPatientByID(id);
    }


    @GetMapping("/getAll")
    public List<PatientDTO> getAllPatients (){
        return this.patientService.getAllPatients();
    }

    @PostMapping(value = "/create")
    public ResponseEntity createCategory(@Valid @RequestBody PatientDTO patientDTO  ) {
        System.out.println("controller: " + patientDTO.getId());

        this.patientService.SavePatient(patientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(patientDTO);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updatePatient(@Valid @RequestBody PatientDTO patientDTO , @PathVariable (name = "id") Integer id){
        this.patientService.updatePatient(patientDTO , id);
        return ResponseEntity.status(HttpStatus.CREATED).body(patientDTO);
    }


    @DeleteMapping("/delete/{id}")
    public void deletePatient(@PathVariable(name = "id") Integer integer) {
        this.patientService.deletePatient(integer);
    }


}
