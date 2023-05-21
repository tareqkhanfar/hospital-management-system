package com.tareqkhanfar.healthSystem.Service;


import com.tareqkhanfar.healthSystem.Model.Repository.AppoinmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    private AppoinmentRepo appoinmentRepo ;


}
