package com.tareqkhanfar.healthSystem.Model.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "Doctor")
public class Doctor extends Person{
    @Id
    @Column(name = "Doctor_id")
    private Integer id ;
    @Column(name = "specialization")
    private String specialization ;
    @Column(name = "qualifications")

    private String qualifications ;

    @Column(name = "avaliability")
    private String avaliability ;

    @Column(name = "salary")

    private Double salary ;

    @Column(name = "is_Active")

    private Boolean isActive;


    @JsonManagedReference
    @OneToMany(mappedBy = "appintment_doctor")
    private List<Appointment> appointmentList ;
    public Doctor() {

    }
}
