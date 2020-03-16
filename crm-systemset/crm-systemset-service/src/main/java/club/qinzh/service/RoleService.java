package club.qinzh.service;

import club.qinzh.bean.Role;
import club.qinzh.bean.RoleExample;
import club.qinzh.enums.ExceptionEnums;
import club.qinzh.exception.CrmException;
import club.qinzh.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Atuhor: qin
 * @Create: 2020-03-09-16-32
 * @Time: 16:32
 * @Description:
 */
public interface RoleService {
    Role findById(Long id);
    List<Role> findAllRole();
    void saveOrUpadte(Role role);
    void deleteById(Long id);
}
