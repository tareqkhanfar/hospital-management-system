package com.tareqkhanfar.healthSystem.Controller;


import com.tareqkhanfar.healthSystem.Model.DTO.AppointmentDTO;
import com.tareqkhanfar.healthSystem.Model.DTO.DoctorDTO;
import com.tareqkhanfar.healthSystem.Model.DTO.PatientDTO;
import com.tareqkhanfar.healthSystem.Model.Entity.Doctor;
import com.tareqkhanfar.healthSystem.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {


    @Autowired
    private DoctorService doctorService;




    @GetMapping("/getById/{id}")
    public DoctorDTO getDoctorById (@PathVariable(name = "id") Integer id) {

       return  this.doctorService.getById(id);

    }



    @GetMapping("/getAll")
    public List<DoctorDTO> getAllDoctors (){
        System.out.println("test");
        return this.doctorService.getAll();
    }

    @PostMapping(value = "/create")
    public ResponseEntity createCategory(@Valid @RequestBody DoctorDTO doctorDTO  ) {

        this.doctorService.SavePatient(doctorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorDTO);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateDoctor(@Valid @RequestBody DoctorDTO doctorDTO , @PathVariable (name = "id") Integer id){
        this.doctorService.updateDoctor(id , doctorDTO );
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorDTO);
    }


    @DeleteMapping("/delete/{id}")
    public void deletePatient(@PathVariable(name = "id") Integer integer) {
        this.doctorService.deleteDoctor(integer);
    }




}
