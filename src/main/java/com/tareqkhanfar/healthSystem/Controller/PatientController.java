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

    @GetMapping("/getById/{id}")
    public ResponseEntity<PatientDTO> getPatientByID(@PathVariable(name = "id") Integer id) {
        PatientDTO patient = this.patientService.getPatientByID(id);
        if (patient != null) {
            return ResponseEntity.ok(patient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        List<PatientDTO> patients = this.patientService.getAllPatients();
        return ResponseEntity.ok(patients);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<PatientDTO> createCategory(@Valid @RequestBody PatientDTO patientDTO) {
        PatientDTO createdPatient = this.patientService.SavePatient(patientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPatient);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PatientDTO> updatePatient(@Valid @RequestBody PatientDTO patientDTO, @PathVariable(name = "id") Integer id) {
        PatientDTO updatedPatient = this.patientService.updatePatient(patientDTO, id);
        if (updatedPatient != null) {
            return ResponseEntity.ok(updatedPatient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable(name = "id") Integer id) {
        boolean isDeleted = this.patientService.deletePatient(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
