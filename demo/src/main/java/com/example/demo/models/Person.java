package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    private String name;
    private String email;
    private Integer age;
//    @Transient
//    @JsonInclude(JsonInclude.Include.NON_EMPTY)
//    @OneToOne(mappedBy = "person",cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    private Address address;
//
//    public void setAddress(Address address) {
//        this.address = address;
//        this.address.setPerson(this);
//    }
}
