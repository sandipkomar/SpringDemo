package com.springbatch.batchdemo.listener;

import java.util.List;

import org.springframework.batch.core.ItemWriteListener;

public class StepItemWriteListener implements ItemWriteListener<Number> {

	@Override
	public void beforeWrite(List<? extends Number> items) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterWrite(List<? extends Number> items) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onWriteError(Exception exception, List<? extends Number> items) {
		// TODO Auto-generated method stub
		
	}

}
