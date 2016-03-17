package com.weebinar.jest;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.searchbox.client.JestClient;
import io.searchbox.core.Index;

public class PostTest implements Runnable {



	public void run() {
		while(true){
			try {
				Thread.sleep(5);
			} catch (InterruptedException e1) {
			}
			put();
		}

	}


	private void put() {
		JestClient client = new Jest().client();
		MemberBean bean = makeMemberBean();
		try {
			String esId = bean.getEsId();
			Index index = new Index.Builder(bean).index("i_member").type("member").id(esId).build();
			client.execute(index);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.shutdownClient();
		}
	}


	private MemberBean makeMemberBean() {
		MemberBean bean = new MemberBean();
		String esId = UUID.randomUUID().toString();
		bean.setEsId(esId);
		bean.setName(esId);
		return bean;
	}


	public static void main(String agsp[]){
		ExecutorService threadPool = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 50; i++){
			threadPool.execute(new PostTest());
		}
	}

}


