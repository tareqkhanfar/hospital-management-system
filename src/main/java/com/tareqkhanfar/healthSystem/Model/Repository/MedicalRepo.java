package com.tareqkhanfar.healthSystem.Model.Repository;

import com.tareqkhanfar.healthSystem.Model.Entity.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRepo extends JpaRepository<MedicalRecord , Integer> {

}
