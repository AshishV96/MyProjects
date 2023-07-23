package net.relation.mapping.entity;

import javax.persistence.*;
import java.util.List;

@NamedNativeQuery(name = "Student.getNameAndAbout",
        query = "select student_name,about from student where student_id = ?1",
        resultSetMapping = "Mapping.StudentDetails")

@SqlResultSetMapping(name = "Mapping.StudentDetails",
        entities = {@EntityResult(entityClass = Student.class,
                fields = {@FieldResult(name = "studentName",column = "student_name"),
                        @FieldResult(name = "about",column = "about"),
        })})

//@SqlResultSetMapping(name = "Mapping.StudentDTO",
//                    classes = @ConstructorResult(targetClass = StudentDTO.class,
//                            columns = {
//                            @ColumnResult(name = "student_name"),
//                            @ColumnResult(name = "about")}))


@Entity
@Table(name = "student")
public class Student {
    @Id
    private Integer studentId;
    private String studentName;
    private String about;
//    @OneToOne(cascade = CascadeType.ALL)
//    @MapsId
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<Laptop> laptops;

    public Student() {
    }

    public Student(Integer studentId, String studentName, String about, List<Laptop> laptops) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.about = about;
        this.laptops = laptops;
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

    public List<Laptop> getLaptops() {
        return laptops;
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

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", about='" + about + '\'' +
                ", laptop=" + laptops +
                '}';
    }
}