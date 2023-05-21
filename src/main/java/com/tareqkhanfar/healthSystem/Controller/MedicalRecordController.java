package com.tareqkhanfar.healthSystem.Controller;

import com.tareqkhanfar.healthSystem.Service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicalRecordController {


    @Autowired
    private MedicalService medicalService ;
}
