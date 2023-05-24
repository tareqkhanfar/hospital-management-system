package com.tareqkhanfar.healthSystem.Controller;

import com.tareqkhanfar.healthSystem.Model.DTO.AppointmentDTO;
import com.tareqkhanfar.healthSystem.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/getById/{id}")
    public ResponseEntity<AppointmentDTO> getById(@PathVariable(name = "id") Integer id) {
        AppointmentDTO appointmentDTO = appointmentService.getById(id);
        if (appointmentDTO != null) {
            return ResponseEntity.ok(appointmentDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getAll")
    public List<AppointmentDTO> getAll() {
        return appointmentService.getAll();
    }

    @PostMapping(value = "/create")
    public ResponseEntity<AppointmentDTO> create(@Valid @RequestBody AppointmentDTO appointmentDTO) {
        appointmentService.saveAppointment(appointmentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AppointmentDTO> update(
            @PathVariable(name = "id") Integer id,
            @Valid @RequestBody AppointmentDTO appointmentDTO) {
        AppointmentDTO updatedAppointment = appointmentService.updateAppointment(id, appointmentDTO);
        if (updatedAppointment != null) {
            return ResponseEntity.ok(updatedAppointment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer id) {
        boolean deleted = appointmentService.deleteAppointment(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
