package Node;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@SpringBootApplication
public class Main {

	public static void main(String[] args)  {
		SpringApplication.run(Node.Main.class, args);
	}

}
