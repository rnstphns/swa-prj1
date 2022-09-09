package edu.miu.swa.batch.batch;

import edu.miu.swa.batch.model.Student;
import edu.miu.swa.batch.repository.StudentRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<Student> {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void write(List<? extends Student> items) throws Exception {

        studentRepository.saveAll(items);
        System.out.println("Data Saved for Students: " + items);
    }
}
