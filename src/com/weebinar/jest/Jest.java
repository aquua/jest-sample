package com.weebinar.jest;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;

public class Jest {

	public JestClient client(){
		JestClientFactory factory = new JestClientFactory();
		 factory.setHttpClientConfig(new HttpClientConfig
                 .Builder("http://192.168.0.9:9200")
                 .multiThreaded(true)
                 .connTimeout(5000)
                 .build());
		return factory.getObject();
	}
	
}
