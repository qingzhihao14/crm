package club.qinzh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("club.qinzh.mapper")
public class CrmSystemsetApplication {
    public static void main(String[] args) {
        SpringApplication.run(CrmSystemsetApplication.class,args);
    }
}
