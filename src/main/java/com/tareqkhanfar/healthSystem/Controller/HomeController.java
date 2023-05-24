package com.tareqkhanfar.healthSystem.Controller;


import com.tareqkhanfar.healthSystem.Model.DTO.PatientDTO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class HomeController {


    public String home( ) {
        return "hello - home page ";
    }


}
