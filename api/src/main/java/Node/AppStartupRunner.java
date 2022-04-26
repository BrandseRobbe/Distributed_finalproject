package Node;


import Utilities.Multicast;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AppStartupRunner implements ApplicationRunner {

    private final Multicast multicastReceiver;

    public AppStartupRunner() {
        multicastReceiver = new Multicast();
    }

    @Override
    public void run(ApplicationArguments args) throws IOException {
        multicastReceiver.listenMulticast();
        System.out.println("lalaal");
        multicastReceiver.multicast("message");
    }
}
