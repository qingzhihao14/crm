package club.qinzh.web.controller;

import club.qinzh.bean.Role;
import club.qinzh.bean.User;
import club.qinzh.bean.extend.UserExtend;
import club.qinzh.enums.ExceptionEnums;
import club.qinzh.service.UserService;
import com.spring4all.swagger.EnableSwagger2Doc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.aspectj.bridge.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Atuhor: qin
 * @Create: 2020-03-12-09-38
 * @Time: 9:38
 * @Description:
 */
@RestController
@RequestMapping("/user")
@EnableSwagger2Doc
@Api(value="用户管理",tags = {"用户管理"})
public class UserController {
    @Autowired
    private UserService userservice;
    @PostMapping("/findByNameAndPassword")
    public User findByNameAndPassword(String username,String password){
        return userservice.findByNameAndPassword(username,password);
    };
    @GetMapping("/selectById")
    @ApiOperation("根据id查询用户")
    public ResponseEntity selectById(Long id){
        User user = userservice.findById(id);
        return ResponseEntity.ok(user);
    }
    @GetMapping("/getAll")
    @ApiOperation("查询所有用户")
    public ResponseEntity selectAll(){
        return ResponseEntity.ok(userservice.findAllUser());
    }
    @GetMapping("/getAllWithRole")
    @ApiOperation("查询所有用户")
    public ResponseEntity selectAllWithRole(){
        return ResponseEntity.ok(userservice.findAllUserwithRole());
    }
    @PostMapping("/save")
    @ApiOperation("新增用户")
    public ResponseEntity save(@RequestBody User user){
        userservice.saveOrUpadte(user);
        return ResponseEntity.ok(ExceptionEnums.SUCCESS);
    }
    @PostMapping("/update")
    @ApiOperation("修改用户")
    public ResponseEntity update(@RequestBody User user){
        userservice.saveOrUpadte(user);
        return  ResponseEntity.ok(ExceptionEnums.SUCCESS);
    }
    @GetMapping("/delete")
    @ApiOperation("删除用户")
    public ResponseEntity delete(Long id){
        userservice.deleteById(id);
        return ResponseEntity.ok(ExceptionEnums.SUCCESS);
    }

    @ApiOperation(value="通过id查询User附带Role表内容")
    @GetMapping("findById")
    public ResponseEntity findById(long id){
        userservice.findById(id);
        return ResponseEntity.ok(ExceptionEnums.SUCCESS);
    }
}
