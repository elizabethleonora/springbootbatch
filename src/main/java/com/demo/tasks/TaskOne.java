package com.demo.tasks;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;


/*
The first step is to create few tasks which will be run in some sequence to form a job. In Spring batch, they are implemented as Tasklet.
 */

public class TaskOne implements Tasklet {

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("Starting task 1");

        System.out.println("Finished task 1");
        return RepeatStatus.FINISHED;
    }

}
