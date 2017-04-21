package hu.odrin7.bga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@SpringBootApplication
@EnableConfigServer
public class BGAConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(BGAConfigApplication.class, args);
    }

}
