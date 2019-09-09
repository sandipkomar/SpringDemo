package com.springbatch.batchdemo.listener;

import org.springframework.batch.core.SkipListener;

public class StepSkipListener implements SkipListener<String, Number> {

	@Override
	public void onSkipInRead(Throwable t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSkipInWrite(Number item, Throwable t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSkipInProcess(String item, Throwable t) {
		// TODO Auto-generated method stub

	}

}
