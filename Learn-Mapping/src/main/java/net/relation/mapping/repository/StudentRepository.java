package net.relation.mapping.repository;

import net.relation.mapping.entity.Student;
import net.relation.mapping.entity.StudentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

//    @Query("Select new net.relation.mapping.entity.StudentDTO(s.studentName,s.about) from Student s where s.studentId = ?1")
//    public StudentDTO getSelected(Integer id);

//    @Query(nativeQuery = true)
//    public StudentDTO getNameAndAbout(Integer id);

    @Query(nativeQuery = true)
    public Student getNameAndAbout(Integer id);

}
