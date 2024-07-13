package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {

    @Id
    @Column(name = "person_id")
    private Integer id;
    private String streetName;
    private String locality;
    private String city;
    private String state;
    private long pincode;

//    @JsonIgnore
//    @OneToOne
//    @MapsId
//    @JoinColumn(name = "p_id")
//    private Person person;
}
