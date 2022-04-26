package Nameserver.api;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Component
public class AppStartupRunner implements ApplicationRunner {

    private final testasync newtestasync;

    public AppStartupRunner(testasync newtestasync) {
        this.newtestasync = newtestasync;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
       newtestasync.printa();
       newtestasync.printb();
    }
}
