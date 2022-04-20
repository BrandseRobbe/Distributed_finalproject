package Node;

import java.io.IOException;

public class Discovery {
    public static void Discover() throws IOException {
        MulticastPublisher multicastPublisher = new MulticastPublisher();
        MulticastReceiver multicastReceiver = new MulticastReceiver();
        multicastReceiver.run();
        multicastPublisher.multicast("hello");

        multicastReceiver.run();
    }
}
