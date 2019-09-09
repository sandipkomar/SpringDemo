package com.springbatch.batchdemo.task;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class TaskTwo implements Tasklet {

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		System.out.println("Start task two from here");
		for(int i = 0; i < 5; i++) {
			System.out.println("Working on task two: ");
		}
		System.out.println("Task two completed: ");
		return RepeatStatus.FINISHED;
	}

}
