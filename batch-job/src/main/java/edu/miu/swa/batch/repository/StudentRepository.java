package edu.miu.swa.batch.repository;

import edu.miu.swa.batch.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
