package edu.miu.swa.batch.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Student {

    @Id
    private Integer studentId;
    private String fname;
    private String lname;
    private Double GPA;
    private Integer age;
    private LocalDate DOB;
}
