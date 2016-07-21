package com.tangzq.batcher;

/**
 * 批计算接口,其他所有需要定时执行的任务都实现该接口
 */
public interface BatchCalculator {
	void calculate();
}