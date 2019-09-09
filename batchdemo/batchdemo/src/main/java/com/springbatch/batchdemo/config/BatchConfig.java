package com.springbatch.batchdemo.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.batchdemo.listener.JobResultListener;
import com.springbatch.batchdemo.listener.StepItemReadListener;
import com.springbatch.batchdemo.listener.StepResultListener;
import com.springbatch.batchdemo.task.TaskOne;
import com.springbatch.batchdemo.task.TaskTwo;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobs;

	@Autowired
	private StepBuilderFactory steps;

	@Bean
	public Step stepOne() {
		return steps.get("stepOne").listener(new StepResultListener()).tasklet(new TaskOne()).build();
	}

	@Bean
	public Step stepTwo() {
		return steps.get("stepTwo").listener(new StepItemReadListener()).tasklet(new TaskTwo()).build();
	}

	@Bean
	@Qualifier("demoJob")
	public Job demoJob() {
		return jobs.get("demoJob").incrementer(new RunIdIncrementer()).listener(new JobResultListener())
				.start(stepOne()).next(stepTwo()).build();
	}

	@Bean
	@Qualifier("demoJob2")
	public Job demoJob2() {
		return jobs.get("demoJob2").incrementer(new RunIdIncrementer()).listener(new JobResultListener())
				.start(stepOne()).build();
	}
}
