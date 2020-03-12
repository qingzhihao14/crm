package club.qinzh.web.controller;

import club.qinzh.bean.User;
import club.qinzh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Atuhor: qin
 * @Create: 2020-03-12-09-38
 * @Time: 9:38
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;
    @PostMapping("/findByNameAndPassword")
    public User findByNameAndPassword(String username,String password){
        return service.findByNameAndPassword(username,password);
    };

}
