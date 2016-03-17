package com.weebinar.jest;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.RandomUtils;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Get;

public class GetTest implements Runnable {



	public void run() {
		while(true){
			try {
				Thread.sleep(5);
			} catch (InterruptedException e1) {
			}
			search();
		}

	}


	private void search() {
		Get get = new Get.Builder("i_member", TestData.ids()).type("member").build();

		JestClient client = new Jest().client();
		try {
			JestResult result = client.execute(get);
			MemberBean article = result.getSourceAsObject(MemberBean.class);
			if ( article == null ){
				System.out.println("err");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.shutdownClient();
		}
	}


	public static void main(String agsp[]){
		ExecutorService threadPool = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 100; i++){
			threadPool.execute(new GetTest());
		}
	}

}


