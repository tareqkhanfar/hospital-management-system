package com.tareqkhanfar.healthSystem.Controller;


import com.tareqkhanfar.healthSystem.Model.Entity.Doctor;
import com.tareqkhanfar.healthSystem.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService ;


    @GetMapping("/getDoctor")
    public Doctor getAllDoctors (@RequestParam Integer id) {

       return  this.doctorService.getDoctorByID(id);

    }
}
