package com.company.store.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.TaskExecutorJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class StoreJobConfiguration {

    /**
     * @link https://stackoverflow.com/questions/75508267/how-to-solve-deprecation-warning-of-jobbuilderfactory-and-stepbuilderfactory
     * deprecaated 로 인한 JobRepository, trasnactionManager 주입 <br>
     * new JobBuilder, new StepBuilder 추가
     */
    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    public StoreJobConfiguration(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
    }

    @Bean
    public JobLauncher simpleJobLauncher(JobRepository jobRepository) {
        TaskExecutorJobLauncher taskExecutorJobLauncher = new TaskExecutorJobLauncher();
        taskExecutorJobLauncher.setJobRepository(jobRepository);
        return taskExecutorJobLauncher;
    }

    @Bean
    public Step printHelloStep() {
        return new StepBuilder("printHelloStep", jobRepository)
                .tasklet(helloWorldTasklet(), transactionManager)
                .build();
    }

    @Bean
    public Job printHelloJob() {
        return new JobBuilder("printHelloJob", jobRepository)
                .start(printHelloStep())
                .build();
    }

    public Tasklet helloWorldTasklet() {
        return (contribution, chunkContext) -> {
            System.out.println("Hello, World!");
            return RepeatStatus.FINISHED;
        };
    }
}
