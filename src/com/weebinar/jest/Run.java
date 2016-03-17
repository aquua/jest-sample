package com.weebinar.jest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {

	public static void main(String argsp[]){
		ExecutorService threadPool = Executors.newCachedThreadPool();

		for (int i = 0; i < 100; i++){
			threadPool.execute(new PostTest());
		}

		for (int i = 0; i < 200; i++){
			threadPool.execute(new GetTest());
		}
		for (int i = 0; i < 200; i++){
			threadPool.execute(new SearchTest());
		}

	}
}
