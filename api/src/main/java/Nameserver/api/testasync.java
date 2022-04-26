package Nameserver.api;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


import static java.lang.Thread.sleep;

@Component
public class testasync {

    @Async
    public void printa() throws InterruptedException {
        while (true) {
            System.out.println("a");
            sleep(1000);
        }
    }

    @Async
    public void printb() throws InterruptedException {
        while (true) {
            System.out.println("b");
            sleep(500);
        }
    }

}
