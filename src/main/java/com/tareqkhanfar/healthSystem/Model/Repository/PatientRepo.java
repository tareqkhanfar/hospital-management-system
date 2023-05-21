package com.tareqkhanfar.healthSystem.Model.Repository;

import com.tareqkhanfar.healthSystem.Model.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient , Integer> {
}
