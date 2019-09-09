package com.springbatch.batchdemo.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class JobResultListener implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("Before Job process");
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("After Job process");
	}

}
