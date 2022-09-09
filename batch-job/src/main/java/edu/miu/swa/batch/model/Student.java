package edu.miu.swa.batch.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Student {

    @Id
    private String studentId;
    private String fname;
    private String lname;
    private Double GPA;
    private Integer age;
    private LocalDate DOB;
}
