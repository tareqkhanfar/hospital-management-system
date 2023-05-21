package com.tareqkhanfar.healthSystem.Model.Repository;

import com.tareqkhanfar.healthSystem.Model.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppoinmentRepo extends JpaRepository<Appointment , Integer> {
}
