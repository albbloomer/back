package com.company.store.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleScheduler {

    private static final Logger log = LoggerFactory.getLogger(ScheduleScheduler.class);
    private final JobLauncher jobLauncher;
    private final Job job;

    public ScheduleScheduler(JobLauncher simpleJobLauncher, Job printHelloJob) {
        this.jobLauncher = simpleJobLauncher;
        this.job = printHelloJob;
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void runUpdateSchedule() {
        executeJob(job);
    }

    private void executeJob(Job job) {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("requestTime", System.currentTimeMillis())
                    .toJobParameters();
            jobLauncher.run(job, jobParameters);
        } catch (Exception e) {
            log.error("schedule executeJob error : [{}]", e.getMessage(), e);
        }
    }
}
