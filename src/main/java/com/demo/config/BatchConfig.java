package com.demo.config;

import com.demo.tasks.TaskOne;
import com.demo.tasks.TaskTwo;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //Når du har @Configuration vil Spring lete etter Spring definitions i klassen for å lete etter dependency injection
@EnableBatchProcessing //We need to add the @EnableBatchProcessing annotation in the configuration class file. The @EnableBatchProcessing annotation is used to enable the batch operations for your Spring Boot application.
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Bean
    public Step stepOne() {
        return steps.get("stepOne")
                .tasklet(new TaskOne())
                .build();
    }

    @Bean
    public Step stepTwo() {
        return steps.get("stepTwo")
                .tasklet(new TaskTwo())
                .build();
    }

    @Bean
    public Job demoJob(){
        return jobs.get("demoJob")
                .incrementer(new RunIdIncrementer())
                .start(stepOne())
                .next(stepTwo())
                .build();
    }
}
