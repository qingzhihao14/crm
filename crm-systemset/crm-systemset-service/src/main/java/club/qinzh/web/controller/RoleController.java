package club.qinzh.web.controller;

import club.qinzh.bean.Role;
import club.qinzh.enums.ExceptionEnums;
import club.qinzh.exception.CrmException;
import club.qinzh.service.RoleService;
import com.spring4all.swagger.EnableSwagger2Doc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Atuhor: qin
 * @Create: 2020-03-09-16-37
 * @Time: 16:37
 * @Description:
 */
@RestController
@RequestMapping("/role")
@EnableSwagger2Doc
@Api(value="角色管理",tags = {"角色管理"})
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/selectById")
    @ApiOperation("根据id查询角色")
    public ResponseEntity selectById(Long id){
        Role role = roleService.findById(id);
        /*return ResponseEntity.status(200).body(role);*/
        return ResponseEntity.ok(role);
/*        try {
            Role role = roleService.findById(id);
            return ResponseEntity.status(200).body(role);
        }catch (CrmException e){
            e.printStackTrace();
            return ResponseEntity.status(e.getExceptionEnums().getCode())
                                    .body(e.getExceptionEnums().getMsg());
        }*/
    }
    @GetMapping("/getAll")
    @ApiOperation("查询所有角色")
    public ResponseEntity selectAll(){
        return ResponseEntity.ok(roleService.findAllRole());
    }
    @PostMapping("/save")
    @ApiOperation("新增角色")
    public ResponseEntity save(@RequestBody Role role){
        roleService.saveOrUpadte(role);
        return ResponseEntity.ok(ExceptionEnums.SUCCESS);
    }
    @PostMapping("/update")
    @ApiOperation("修改角色")
    public ResponseEntity update(@RequestBody Role role){
        roleService.saveOrUpadte(role);
        return  ResponseEntity.ok(ExceptionEnums.SUCCESS);
    }
    @GetMapping("/delete")
    @ApiOperation("删除角色")
    public ResponseEntity delete(Long id){
        roleService.deleteById(id);
        return ResponseEntity.ok(ExceptionEnums.SUCCESS);
    }
}
