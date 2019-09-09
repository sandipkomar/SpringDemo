package com.springbatch.batchdemo.listener;

import org.springframework.batch.core.ItemReadListener;

public class StepItemReadListener implements ItemReadListener<String> {

	@Override
	public void beforeRead() {
		System.out.println("Step Item before Read");
	}

	@Override
	public void afterRead(String item) {
		System.out.println("Step Item After Read");
	}

	@Override
	public void onReadError(Exception ex) {
		System.out.println("On Step Read Error");
	}

}
