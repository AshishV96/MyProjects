package net.relation.mapping.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class StudentDTO {

    private String studentName;
    private String about;
    private String laptopBrand;

    public StudentDTO(String studentName, String about) {
        this.studentName = studentName;
        this.about = about;
    }

}
