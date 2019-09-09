package com.springbatch.batchdemo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class BatchdemoApplication implements CommandLineRunner {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	@Qualifier(value = "demoJob")
	private Job job;

	public static void main(String[] args) {
		SpringApplication.run(BatchdemoApplication.class, args);
	}

	@Scheduled(cron = "0 */10 * * * ?")
	public void perform() throws Exception {
		JobParameters jobParameters = new JobParametersBuilder()
				.addString("JobId: ", String.valueOf(System.currentTimeMillis())).toJobParameters();
		jobLauncher.run(job, jobParameters);
	}

	@Override
	public void run(String... args) throws Exception {
		JobParameters jobParameters = new JobParametersBuilder()
				.addString("JobId: ", String.valueOf(System.currentTimeMillis())).toJobParameters();
		jobLauncher.run(job, jobParameters);
	}

}
