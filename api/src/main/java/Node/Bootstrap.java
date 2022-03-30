package Node;

import java.io.IOException;

public class Bootstrap {
    public static void main(String[] args) throws IOException {
        MulticastPublisher multicastPublisher = new MulticastPublisher();
        MulticastReceiver multicastReceiver = new MulticastReceiver();
        multicastReceiver.run();
        multicastPublisher.multicast("hello");

        multicastReceiver.run();

    }
}
