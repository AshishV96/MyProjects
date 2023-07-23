package net.relation.mapping.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    private Integer studentId;
    private String studentName;
    private String about;
    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private Laptop laptop;
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL) //One Student Many Address
    private List<Address> addressList = new ArrayList<>();

    public Student() {
    }

    public Student(Integer studentId, String studentName, String about, Laptop laptop, List<Address> addressList) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.about = about;
        this.laptop = laptop;
        this.addressList = addressList;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getAbout() {
        return about;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

//    @Override
//    public String toString() {
//        return "Student{" +
//                "studentId=" + studentId +
//                ", studentName='" + studentName + '\'' +
//                ", about='" + about + '\'' +
//                ", laptop=" + laptop +
//                '}';
//    }
}