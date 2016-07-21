package com.tangzq.tasks;

import com.tangzq.batcher.BatchCalculator;
import com.tangzq.batcher.BatchCalculatorTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 任务3
 * Author tangzq.
 */
@Service
public class ThirdTask implements BatchCalculator {

    private static final Logger logger = LoggerFactory.getLogger(BatchCalculatorTask.class);

    @Override
    public void calculate() {
        logger.info("$$$$$$$$$$$$$$$$任务3正在执行$$$$$$$$$$$$$$$"+System.currentTimeMillis());
    }
}
