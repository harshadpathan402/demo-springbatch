package com.harshad.demospringbatch.config;

import com.harshad.demospringbatch.domain.User;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    // tag::readerwriterprocessor[]
    @Bean
    public FlatFileItemReader<User> reader() {
        return new FlatFileItemReaderBuilder<User>()
                .name("personItemReader")
                .resource(new ClassPathResource("user_data.csv"))
                .linesToSkip(1)
                .delimited()
                .delimiter(",")
                .names(new String[]{"id", "firstName", "address", "age"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<User>() {{
                    setTargetType(User.class);
                }})
                .build();

    }

    @Bean
    public UserItemProcessor processor() {
        return new UserItemProcessor();
    }


    @Bean
    public UserItemWriter writer() {
        return new UserItemWriter();
    }

    @Bean
    public Job importUserJob(Step step1) {
        return jobBuilderFactory.get("importUserJob").incrementer(new RunIdIncrementer())
                .flow(step1).end()
                .build();
    }


    @Bean
    public Step step1(UserItemWriter writer) {
        return stepBuilderFactory.get("step1")
                .<User, User>chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }



}
