package com.tareqkhanfar.healthSystem.Model.Repository;

import com.tareqkhanfar.healthSystem.Model.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}
