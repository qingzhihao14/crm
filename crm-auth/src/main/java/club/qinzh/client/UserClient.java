package club.qinzh.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Atuhor: qin
 * @Create: 2020-03-12-09-46
 * @Time: 9:46
 * @Description:
 */
@FeignClient("crm-systemset")
public interface UserClient {
    @PostMapping("/user/findByNameAndPassword")
    Object login(@RequestParam("username") String username, @RequestParam("password") String password);
}
