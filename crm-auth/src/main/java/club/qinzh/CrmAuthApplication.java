package club.qinzh;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2Doc
public class CrmAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmAuthApplication.class, args);
    }

}
