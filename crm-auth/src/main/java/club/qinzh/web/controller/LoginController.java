package club.qinzh.web.controller;

import club.qinzh.enums.ExceptionEnums;
import club.qinzh.utils.JwtTokenUtils;
import club.qinzh.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Atuhor: qin
 * @Create: 2020-03-10-22-55
 * @Time: 22:55
 * @Description:
 */
@RestController
@RequestMapping("/auth")
@Api(value = "登录认证",tags = {"登录认证"})
public class LoginController {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @PostMapping("/login")
    @ApiOperation("登陆")
    public ResponseEntity login(String username,String password){
        if("admin".equals(username)&&"admin".equals(password)){
            String token = JwtTokenUtils.createToken(username);
            redisTemplate.opsForValue().set(username,token);
            return ResponseEntity.ok(token);
        }else {
            return ResponseEntity.status(ExceptionEnums.USERNAME_OR_PASSWORD_ERROR.getCode())
                    .body(new ResponseResult(ExceptionEnums.USERNAME_OR_PASSWORD_ERROR));
        }
    }
}
