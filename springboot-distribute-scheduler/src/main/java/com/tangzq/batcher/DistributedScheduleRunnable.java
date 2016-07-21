package com.tangzq.batcher;

import java.util.concurrent.locks.Lock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 使用线程包装锁
 */
public abstract class DistributedScheduleRunnable implements Runnable {
	private static final Logger logger = Logger.getLogger(DistributedScheduleRunnable.class.getName());

	private final Lock distributedLock;

	protected DistributedScheduleRunnable(Lock distributedLock) {
		this.distributedLock = distributedLock;
	}

	@Override
	public void run() {
		logger.log(Level.FINE, "Run distributed schedule task with distributed lock");
		if (distributedLock.tryLock()) {
			try {
                execute();
			} finally {
				distributedLock.unlock();
			}
		} else {
			logger.log(Level.WARNING,
					"Failed get the lock to run distributed schedule task, it maybe run on other node!");
		}
	}

	protected abstract void execute();
}