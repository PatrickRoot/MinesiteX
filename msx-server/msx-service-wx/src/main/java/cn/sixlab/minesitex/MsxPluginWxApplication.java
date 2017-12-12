package cn.sixlab.minesitex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MsxPluginWxApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(MsxPluginWxApplication.class, args);
    }
}
