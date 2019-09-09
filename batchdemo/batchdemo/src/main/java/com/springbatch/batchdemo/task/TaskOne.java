package com.springbatch.batchdemo.task;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class TaskOne implements Tasklet {

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		System.out.println("Start task one from here");
		for (int i = 0; i < 5; i++) {
			System.out.println("Working on task one: ");
		}
		System.out.println("Task one completed: ");
		return RepeatStatus.FINISHED;
	}

}
