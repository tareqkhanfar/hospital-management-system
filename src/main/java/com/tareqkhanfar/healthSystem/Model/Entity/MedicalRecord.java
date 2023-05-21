package com.tareqkhanfar.healthSystem.Model.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Medical_Record")
public class MedicalRecord {
    @Id
    @Column(name = "record_Id")
    private Integer recordId ;
    @Column(name = "medications")

    private String medications ;
    @Column(name = "lab_Result")

    private String labResult ;
    @Column(name = "diagnosis")

    private String diagnosis ;
    @Column(name = "visit_Date")

    private  String visitDate ;
    @Column(name = "created_BY")

    private String createdBY ;
    @Column(name = "symptoms")

    private String symptoms ;
    @Column(name = "treamtment_Plan")

    private String treamtmentPlan ;
    @Column(name = "next_Appoinment")

    private String nextAppoinment ;

    @Column(name = "patient_id")
    private Integer patient_id_fk;

    /////////////////////////////////

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "patient_id" , insertable = false, updatable = false)
    private Patient patient ;

}
