package com.tareqkhanfar.healthSystem.Service;


import com.tareqkhanfar.healthSystem.Model.Entity.Doctor;
import com.tareqkhanfar.healthSystem.Model.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DoctorService {


    @Autowired
    private DoctorRepository doctorRepository ;


    public Doctor getDoctorByID (Integer id) {
        return doctorRepository.findById(id).get();
    }
}
