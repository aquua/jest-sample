package com.weebinar.jest;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.RandomUtils;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Get;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.core.Update;

public class UpdateTest implements Runnable {



	public void run() {
//		while(true){
			try {
				Thread.sleep(5);
			} catch (InterruptedException e1) {
			}
			search();
//		}

	}


	private void search() {

		JestClient client = new Jest().client();
		try {
			String name = "before : ";
			String id = TestData.ids();
			Get get = new Get.Builder("i_member", id).type("member").build();
			
			JestResult result = client.execute(get);
			MemberBean bean = result.getSourceAsObject(MemberBean.class);
			name = name+bean.getName()+" after : ";
			
			String doc = "{\"doc\" : {#INNER_QUERY#}}";
			String source = "{\"name\": \"udpate1\"}";
			doc = doc.replace("{#INNER_QUERY#}", source);
			
			Update update = new Update.Builder(doc).index("i_member").type("member").id(id).build();
			
			DocumentResult a = client.execute(update);
			get = new Get.Builder("i_member", id).type("member").build();
			result = client.execute(get);
			
			bean = result.getSourceAsObject(MemberBean.class);

			System.out.println(a.getErrorMessage());
			System.out.println(name + bean.getName());
			
		
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			searchSourceBuilder.query(QueryBuilders.termQuery("esId", id));

			Search s = new Search.Builder(searchSourceBuilder.toString())
					.addIndex("i_member")
					.addType("member")
					.build();
			
			result = client.execute(s);
			List<MemberBean> memberList = result.getSourceAsObjectList(MemberBean.class);
			System.out.println(memberList.get(0).getName());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.shutdownClient();
		}
	}


	public static void main(String agsp[]){
		ExecutorService threadPool = Executors.newFixedThreadPool(3);

//		for (int i = 0; i < 100; i++){
			threadPool.execute(new UpdateTest());
//		}
	}

}


