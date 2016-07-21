package com.tangzq;

import com.tangzq.batcher.BatchCalculator;
import com.tangzq.batcher.BatchCalculatorTask;
import com.tangzq.config.PropertiesTask;
import org.redisson.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.Lock;

@Component
@EnableConfigurationProperties(PropertiesTask.class)
public class BootstrapHelper implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger logger = LoggerFactory.getLogger(BootstrapHelper.class);

	@Autowired
	private PropertiesTask taskProperties;

	@Autowired
	private TaskScheduler batchCalculatorTaskScheduler;

	@Autowired
	private RedissonClient redissonClient;

	private ApplicationContext applicationContext;


	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		this.applicationContext=event.getApplicationContext();
		scheduleCalculatorTask();
	}

	protected void scheduleCalculatorTask() {
		PropertiesTask.TaskConfig taskConfig = taskProperties.getTask();
		if (taskConfig == null || taskConfig.getTaskMap() == null) {
			logger.warn("No batch calculator will be scheduled!");
			return;
		}
		taskConfig.getTaskMap().forEach((calculatorClass, cronExpression) -> {
			logger.info("Schedule calculate task {} with cron expression {}", calculatorClass, cronExpression);
			BatchCalculator calculator = applicationContext.getBean(calculatorClass);
			batchCalculatorTaskScheduler.schedule(buildBatchCalculatorTask(calculator, calculatorClass.getName()),
					buildCronTrigger(cronExpression));
		});
	}

	private CronTrigger buildCronTrigger(String cronExpression) {
		return new CronTrigger(cronExpression);
	}

	private BatchCalculatorTask buildBatchCalculatorTask(BatchCalculator calculator, String lockSuffix) {
		String lockName = taskProperties.getTask().getDistLockNamePrefix() + calculator.getClass().getName();
		Lock distributedLock = redissonClient.getLock(lockName);
		logger.info("Require distributed lock {} for batch calculator!", lockName);
		return BatchCalculatorTask.wrap(distributedLock, calculator);
	}

}
