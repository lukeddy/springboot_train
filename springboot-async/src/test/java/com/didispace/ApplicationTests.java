package com.didispace;

import com.didispace.async.AsyncTask1;
import com.didispace.async.AsyncTask2;
import com.didispace.sync.SyncTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTests {

	@Autowired
	private SyncTask syncTask;

	@Autowired
	private AsyncTask1 asyncTask1;


	@Autowired
	private AsyncTask2 asyncTask2;


	@Test
	public void testSyncTask() throws Exception {
		syncTask.doTaskOne();
		syncTask.doTaskTwo();
		syncTask.doTaskThree();
	}

	@Test
	public void testAsyncTask1() throws Exception {
		asyncTask1.doTaskOne();
		asyncTask1.doTaskTwo();
		asyncTask1.doTaskThree();
		Thread.sleep(20000);
	}


	@Test
	public void testAsyncTask2() throws Exception {
		long start = System.currentTimeMillis();
		Future<String> taskResult1 = asyncTask2.doTaskOne();
		Future<String> taskResult2 = asyncTask2.doTaskTwo();
		Future<String> taskResult3 = asyncTask2.doTaskThree();
		while(true) {
			if(taskResult1.isDone() && taskResult2.isDone() && taskResult3.isDone()) {
				// 三个任务都调用完成，退出循环等待
				break;
			}
			Thread.sleep(1000);
		}
		long end = System.currentTimeMillis();
		System.out.println("全部完成，总耗时：" + (end - start) + "毫秒");

	}

}
