package com.company.store.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.TaskExecutorJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class StoreJobConfiguration {

    @Bean
    public JobLauncher simpleJobLauncher(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        TaskExecutorJobLauncher taskExecutorJobLauncher = new TaskExecutorJobLauncher();

        taskExecutorJobLauncher.setJobRepository(jobRepository);
        System.out.print(transactionManager);
        return taskExecutorJobLauncher;
    }


}
