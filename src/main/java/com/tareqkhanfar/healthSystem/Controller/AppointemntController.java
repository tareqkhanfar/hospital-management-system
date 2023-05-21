package com.tareqkhanfar.healthSystem.Controller;

import com.tareqkhanfar.healthSystem.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointemntController {


    @Autowired
    private AppointmentService appointmentService;

}
