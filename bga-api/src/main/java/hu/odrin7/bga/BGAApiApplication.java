package hu.odrin7.bga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BGAApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BGAApiApplication.class, args);
    }

}
