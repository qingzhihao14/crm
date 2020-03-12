package club.qinzh.web.controller;

import club.qinzh.client.UserClient;
import club.qinzh.enums.ExceptionEnums;
import club.qinzh.exception.CrmException;
import club.qinzh.utils.JwtTokenUtils;
import club.qinzh.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Atuhor: qin
 * @Create: 2020-03-10-22-55
 * @Time: 22:55
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
class User{
    private String username;
    private String password;
}
@RestController
@RequestMapping("/auth")
@Api(value = "登录认证",tags = {"登录认证"})
public class LoginController {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private UserClient userClient;

    @PostMapping("/login")
    @ApiOperation("登陆")
    public ResponseEntity login(@RequestBody User user){
        String username = user.getUsername();
        String password = user.getPassword();
        System.out.println(username);
        System.out.println(password);
        Object obj = userClient.login(username, password);
        //if("admin".equals(username)&&"admin".equals(password)){
        if(obj != null){
            String token = JwtTokenUtils.createToken(username);
            redisTemplate.opsForValue().set(username,token);
            return ResponseEntity.ok(token);
        }else {
            return ResponseEntity.status(ExceptionEnums.USERNAME_OR_PASSWORD_ERROR.getCode())
                    .body(new ResponseResult(ExceptionEnums.USERNAME_OR_PASSWORD_ERROR));
        }
    }
    @GetMapping("/info")
    public ResponseEntity info(HttpServletRequest request){
        String token = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        if(StringUtils.isBlank(token)){
            throw new CrmException(ExceptionEnums.TOKEN_ERROR);
        }
        return ResponseEntity.ok(JwtTokenUtils.getUsername(token));
    }
    @GetMapping("/loginOut")
    public ResponseEntity loginOut(HttpServletRequest request){
        String token = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        if(StringUtils.isBlank(token)){
            throw new CrmException(ExceptionEnums.TOKEN_ERROR);
        }
        redisTemplate.delete(JwtTokenUtils.getUsername(token));
        return ResponseEntity.ok(ExceptionEnums.SUCCESS);
    }
}
