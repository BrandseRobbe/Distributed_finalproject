package Node;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Node node = new Node();
        node.Discovery();
        node.Bootstrap();
        node.Run();
    }
}
