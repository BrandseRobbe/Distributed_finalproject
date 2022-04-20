package Nameserver.api;

import Node.Node;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
		Node node1 = new Node("nodenaam1");
		node1.Discovery();
		node1.Bootstrap();
		//     node1.Run();

		Node node2 = new Node("Nodenaaaaaam2");
		node2.Discovery();
		node2.Bootstrap();
		//    node2.Run();
	}

}
