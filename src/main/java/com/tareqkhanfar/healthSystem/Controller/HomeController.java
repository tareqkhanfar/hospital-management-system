package com.tareqkhanfar.healthSystem.Controller;


import com.tareqkhanfar.healthSystem.Model.DTO.PatientDTO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/test")
public class HomeController {

    @PostMapping
    public String home( @RequestBody PatientDTO patientDTO) {
        return "hello - home page "+ patientDTO.getId();
    }


}
