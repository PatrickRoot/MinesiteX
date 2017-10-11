package cn.sixlab.mine.site.base.zuul;

import cn.sixlab.mine.site.base.zuul.filter.ApiAuthFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableCaching
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class MsBaseZuulApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(MsBaseZuulApplication.class, args);
    }
    
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
    @Bean
    public ApiAuthFilter apiAuthFilter() {
        return new ApiAuthFilter();
    }
}