package com.tareqkhanfar.healthSystem.Model.Entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class Person {

    @Column(name = "Name")
    private String Name ;
    @Column(name = "Phone")
    private String Phone;
    @Column(name = "age")
    private  Byte age ;
    @Column(name = "Address")
    private String Address ;
    @Column(name = "Email")
    private String Email ;
    @Column(name = "gender")
    private String gender ;



}