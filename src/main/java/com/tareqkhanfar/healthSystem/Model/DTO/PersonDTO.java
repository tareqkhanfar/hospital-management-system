package com.tareqkhanfar.healthSystem.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class PersonDTO {

        protected Integer id;
        protected String name;
        protected String phone;
        protected Byte age;
        protected String address;
        protected String email;
        protected String gender;



}
