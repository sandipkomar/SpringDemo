package com.springbatch.batchdemo.listener;

import org.springframework.batch.core.ItemProcessListener;

public class StepItemProcessListener implements ItemProcessListener<String, Number> {

	@Override
	public void beforeProcess(String item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterProcess(String item, Number result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProcessError(String item, Exception e) {
		// TODO Auto-generated method stub

	}

}
