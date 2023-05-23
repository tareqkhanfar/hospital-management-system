package com.tareqkhanfar.healthSystem.Controller;

import com.tareqkhanfar.healthSystem.Model.DTO.AppointmentDTO;
import com.tareqkhanfar.healthSystem.Model.DTO.DoctorDTO;
import com.tareqkhanfar.healthSystem.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointemntController {


    @Autowired
    private AppointmentService appointmentService;



    @GetMapping("/getById/{id}")
    public AppointmentDTO getById (@PathVariable(name = "id") Integer id) {

        return  this.appointmentService.getById(id);

    }



    @GetMapping("/getAll")
    public List<AppointmentDTO> getAll (){
        return this.appointmentService.getAll();
    }

    @PostMapping(value = "/create")
    public ResponseEntity create(@Valid @RequestBody AppointmentDTO appointmentDTO  ) {

        this.appointmentService.saveAppointment(appointmentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentDTO);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity update(@Valid @RequestBody AppointmentDTO appointmentDTO , @PathVariable (name = "id") Integer id){
        this.appointmentService.updateAppointment(id , appointmentDTO );
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentDTO);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") Integer integer) {
        this.appointmentService.deleteAppointment(integer);
    }


}
