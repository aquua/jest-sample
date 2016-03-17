package com.weebinar.jest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.RandomUtils;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import io.searchbox.client.JestClient;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

public class SearchTest implements Runnable {



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
		String []ids =	{"kanzi","01071101171","01068268810","01067260206","01020816319","testtype77","Naomia"
				,"s1777","gayoung0921","yoon112","Naomia"};
		int a= RandomUtils.nextInt(0, ids.length);


		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.termQuery("esId", TestData.ids()));
		
		Search s = new Search.Builder(searchSourceBuilder.toString())
				.addIndex("i_member")
				.addType("member")
				.build();
		JestClient client = new Jest().client();

		try {
			SearchResult result = client.execute(s);
			List<MemberBean> memberList = result.getSourceAsObjectList(MemberBean.class);
			if ( memberList.size()==0){
				System.out.println("error");
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
			threadPool.execute(new SearchTest());
		}

	}

}


