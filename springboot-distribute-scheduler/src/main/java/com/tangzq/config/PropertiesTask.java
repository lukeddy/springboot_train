package com.tangzq.config;

import com.tangzq.batcher.BatchCalculator;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;


@Getter
@Setter
@ConfigurationProperties("config.scheduler")
public class PropertiesTask {

	private TaskConfig task = new TaskConfig();

	@Getter
	@Setter
	public static class TaskConfig {

		/**
		 * 计划任务分布式锁名称 前缀
		 */
		private String distLockNamePrefix = "my_task_lock_";

		/**
		 * 同时运行的任务,默认设置为4
		 */
		private int concurrentSize = 4;

		/**
		 * Key: 所有实现com.tangzq.batcher.BatchCalculator的Spring Bean.
		 * Value: cron 表达式
		 */
		private Map<Class<BatchCalculator>, String> taskMap;
	}
}
