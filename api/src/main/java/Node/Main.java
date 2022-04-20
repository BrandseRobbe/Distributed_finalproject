package Node;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
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
