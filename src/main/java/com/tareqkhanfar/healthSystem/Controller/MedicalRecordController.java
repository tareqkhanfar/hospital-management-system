package com.tareqkhanfar.healthSystem.Controller;

import com.tareqkhanfar.healthSystem.Model.DTO.AppointmentDTO;
import com.tareqkhanfar.healthSystem.Model.DTO.MedicalRecordDTO;
import com.tareqkhanfar.healthSystem.Service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/medical")
public class MedicalRecordController {


    @Autowired
    private MedicalService medicalService ;





    @GetMapping("/getById/{id}")
    public MedicalRecordDTO getById (@PathVariable(name = "id") Integer id) {

        return  this.medicalService.getById(id);

    }



    @GetMapping("/getAll")
    public List<MedicalRecordDTO> getAllMedicalRecords (){
        return this.medicalService.getAll();
    }

    @PostMapping(value = "/create")
    public ResponseEntity createMedicalRecord(@Valid @RequestBody MedicalRecordDTO medicalRecordDTO  ) {

        this.medicalService.saveAppointment(medicalRecordDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicalRecordDTO);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateMedicalRecord(@Valid @RequestBody MedicalRecordDTO medicalRecordDTO , @PathVariable (name = "id") Integer id){
        this.medicalService.updateMedicalRecord(id , medicalRecordDTO );
        return ResponseEntity.status(HttpStatus.CREATED).body(medicalRecordDTO);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteMedicalRecord(@PathVariable(name = "id") Integer integer) {
        this.medicalService.deleteMedicalRecord(integer);
    }


}
