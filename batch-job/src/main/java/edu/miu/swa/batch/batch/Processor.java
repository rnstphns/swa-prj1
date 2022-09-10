package edu.miu.swa.batch.batch;

import edu.miu.swa.batch.model.Student;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Processor implements ItemProcessor<Student, Student> {

    @Override
    public Student process(Student student) throws Exception {
        //TODO this processing might fail
        int age = student.getAge();
        int year = LocalDate.now().getYear() - age;
        student.setDOB(LocalDate.of(year,01,01));
        System.out.println(String.format("Converted age [%s] to birth year[%s]", age, year));
        return student;
    }
}
