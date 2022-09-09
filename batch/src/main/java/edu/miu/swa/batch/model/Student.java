package edu.miu.swa.batch.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    @Id
    private String studentId;
    private String fname;
    private String lname;
    private String GPA;
    private String DOB;
}
