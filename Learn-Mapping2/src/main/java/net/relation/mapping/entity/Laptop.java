package net.relation.mapping.entity;

import javax.persistence.*;

@Entity
@Table(name = "laptop")
public class Laptop {
    @Id
    private Integer laptopId;
    private String modelNumber;
    private String brand;
    @OneToOne
    private Student student;

    public Laptop() {
    }

    public Laptop(int laptopId, String modelNumber, String brand, Student student) {
        this.laptopId = laptopId;
        this.modelNumber = modelNumber;
        this.brand = brand;
        this.student = student;
    }

    public Integer getLaptopId() {
        return laptopId;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public String getBrand() {
        return brand;
    }

    public Student getStudent() {
        return student;
    }

    public void setLaptopId(Integer laptopId) {
        this.laptopId = laptopId;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

//    @Override
//    public String toString() {
//        return "Laptop{" +
//                "laptopId=" + laptopId +
//                ", modelNumber='" + modelNumber + '\'' +
//                ", brand='" + brand + '\'' +
//                ", student=" + student +
//                '}';
//    }
}

