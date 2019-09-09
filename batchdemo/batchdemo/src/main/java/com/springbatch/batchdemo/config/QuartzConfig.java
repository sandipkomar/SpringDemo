package com.springbatch.batchdemo.config;

import java.io.IOException;
import java.util.Properties;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.springbatch.batchdemo.jobs.CustomQuartzJob;

@Configuration
public class QuartzConfig {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private JobLocator jobLocator;

	@Bean
	public JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor(JobRegistry jobRegistry) {
		JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor = new JobRegistryBeanPostProcessor();
		jobRegistryBeanPostProcessor.setJobRegistry(jobRegistry);
		return jobRegistryBeanPostProcessor;
	}

	@Bean
	public JobDetail jobOneDetail() {
		JobDataMap jobDataMap = new JobDataMap();
		jobDataMap.put("jobName", "demoJob");
		jobDataMap.put("jobLocator", jobLocator);
		jobDataMap.put("jobLauncher", jobLauncher);

		return JobBuilder.newJob(CustomQuartzJob.class).withIdentity("demoJob").setJobData(jobDataMap).storeDurably()
				.build();
	}

	@Bean
	public JobDetail jobTwoDetail() {
		JobDataMap jobDataMap = new JobDataMap();
		jobDataMap.put("jobName", "demoJob2");
		jobDataMap.put("jobLocator", jobLocator);
		jobDataMap.put("jobLauncher", jobLauncher);

		return JobBuilder.newJob(CustomQuartzJob.class).withIdentity("demoJob2").setJobData(jobDataMap).storeDurably()
				.build();
	}

	@Bean
	public Trigger jobOneTrigger() {
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10)
				.repeatForever();
		return TriggerBuilder.newTrigger().forJob(jobOneDetail()).withSchedule(scheduleBuilder)
				.withIdentity("jobOneTrigger").build();
	}

	@Bean
	public Trigger jobTwoTrigger() {
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(20)
				.repeatForever();
		return TriggerBuilder.newTrigger().forJob(jobTwoDetail()).withSchedule(scheduleBuilder)
				.withIdentity("jobTwoTrigger").build();
	}

	@Bean
	public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		schedulerFactoryBean.setTriggers(jobOneTrigger(), jobTwoTrigger());
		schedulerFactoryBean.setQuartzProperties(quartzProperties());
		schedulerFactoryBean.setJobDetails(jobOneDetail(), jobTwoDetail());
		return schedulerFactoryBean;
	}

	@Bean
	public Properties quartzProperties() throws IOException {
		PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
		propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
		propertiesFactoryBean.afterPropertiesSet();
		return propertiesFactoryBean.getObject();
	}
}
