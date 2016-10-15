package hu.odrin7.bga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class BGADiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(BGADiscoveryApplication.class, args);
    }

}
