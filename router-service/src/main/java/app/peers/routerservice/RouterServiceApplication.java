package app.peers.routerservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class RouterServiceApplication {

	@Value("${server.port}")
	private String port;

	public static void main(String[] args) {
		SpringApplication.run(RouterServiceApplication.class, args);
	}

	@GetMapping("/hello")
	public String sayHello() {
		return "hello world ! from "+port;
	}

	@GetMapping("/env") 
	public Map<String,String> getEnvironment() {
		Map<String,String> map = new HashMap<String,String>();
		System.getProperties().forEach((key,value) ->map.put(key.toString(), value.toString()));
		return map;
	}

}
