package sequencegenerator;

/**
 * Created by silva on 18.09.16..
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {



    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Throwable {
        log.info("Dobar dan!");
        SpringApplication.run(Application.class, args);


    }
}