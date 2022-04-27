package Nameserver.api;

import Node.Node;
import Utilities.Multicast;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.File;
import java.io.IOException;

@SpringBootTest
@EnableAsync
class ApiApplicationTests {

	@Test
	void contextLoads() throws IOException {
		Multicast multicast = new Multicast();
		multicast.listenMulticast();
		multicast.multicast("lala");
/*
		Node node1 = new Node("nodenaam1");
		node1.Discovery();
		node1.Bootstrap();
//		node1.Run();

		Node node2 = new Node("Nodenaaaaaam2");
		node2.Discovery();
		node2.Bootstrap();
*/

		//    node2.Run();
//		FileObj fileObj = new FileObj();
//		System.out.println("testing start");
//		System.out.println(fileObj.HashFile("alk"));
//		System.out.println(fileObj.HashFile("alk"));
//		System.out.println(fileObj.HashFile("qsdfaze"));
//		System.out.println(fileObj.HashFile("0ffA"));
//		System.out.println(fileObj.HashFile("PAZFAE"));
//		System.out.println(fileObj.HashFile("1"));
//		System.out.println(fileObj.HashFile("1234135"));
//		System.out.println(fileObj.HashFile("PAZFAE"));
//		System.out.println(fileObj.HashFile("1AZYMf"));
//		System.out.println(fileObj.HashFile("12341356"));
	}
}
