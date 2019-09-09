package com.springbatch.batchdemo.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class StepResultListener implements StepExecutionListener {

	@Override
	public void beforeStep(StepExecution stepExecution) {
		System.out.println("Before Step porcess");
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		System.out.println("After step process");
		return ExitStatus.COMPLETED;
	}
	
}
