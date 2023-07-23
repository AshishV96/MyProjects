package net.relation.mapping.entity;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    private Integer addressId;
    private String street;
    private String city;
    private String country;
    @ManyToOne //Many address can have one student
    @JoinColumn(name = "student_id")
    private Student student;

    public Address() {
    }
    public Address(Integer addressId, String state, String city, String country, Student student) {
        this.addressId = addressId;
        this.street = state;
        this.city = city;
        this.country = country;
        this.student = student;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
