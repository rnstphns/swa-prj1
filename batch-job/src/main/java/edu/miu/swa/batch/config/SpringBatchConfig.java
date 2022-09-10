package edu.miu.swa.batch.config;

import edu.miu.swa.batch.model.Student;
import org.aspectj.apache.bcel.util.ClassPath;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@EnableBatchProcessing
@Configuration
public class SpringBatchConfig {

    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory,
                   StepBuilderFactory stepBuilderFactory,
                   ItemReader<Student> itemReader,
                   ItemProcessor<Student, Student> itemProcessor,
                   ItemWriter<Student> itemWriter
                   ){
        Step step = stepBuilderFactory.get("CSV-file-load")
                        .<Student,Student>chunk(100)
                        .reader(itemReader)
                        .processor(itemProcessor)
                        .writer(itemWriter)
                        .build();

        return jobBuilderFactory.get("CSV-Load")
                .incrementer(new RunIdIncrementer())
                .start(step) //multiple steps with .flow(), not needed here
                .build();
    }

//    @Bean
//    public FlatFileItemReader<Student> itemReader(@Value("${input}") Resource resource){
//        FlatFileItemReader<Student> flatFileItemReader = new FlatFileItemReader<>();
//        flatFileItemReader.setResource(resource);
//        flatFileItemReader.setName("CSV-Reader");
//        flatFileItemReader.setLinesToSkip(1);
//        flatFileItemReader.setLineMapper(lineMapper());
//
//        return flatFileItemReader;
//    }

    @Bean
    public FlatFileItemReader<Student> itemReader(){
        FlatFileItemReader<Student> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(new ClassPathResource("students.csv"));
        flatFileItemReader.setName("CSV-Reader");
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setLineMapper(lineMapper());

        return flatFileItemReader;
    }

    @Bean
    public LineMapper<Student> lineMapper() {
        DefaultLineMapper<Student> defaultLineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames(new String[]{"studentId", "fname", "lname", "GPA", "age"});

        BeanWrapperFieldSetMapper<Student> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Student.class);

        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);

        return defaultLineMapper;
    }
}
