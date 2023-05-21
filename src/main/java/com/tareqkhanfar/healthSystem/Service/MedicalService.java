package com.tareqkhanfar.healthSystem.Service;

import com.tareqkhanfar.healthSystem.Model.Repository.MedicalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalService {

    @Autowired
    private MedicalRepo medicalRepo ;
}
