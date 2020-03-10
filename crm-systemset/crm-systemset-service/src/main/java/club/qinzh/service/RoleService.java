package club.qinzh.service;

import club.qinzh.bean.Role;
import club.qinzh.enums.ExceptionEnums;
import club.qinzh.exception.CrmException;
import club.qinzh.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Atuhor: qin
 * @Create: 2020-03-09-16-32
 * @Time: 16:32
 * @Description:
 */
@Service
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;

    public Role findById(Long id){
        if(id == null){
            throw new CrmException(ExceptionEnums.PARAM_IS_NULL);
        }
        return roleMapper.selectByPrimaryKey(id);
    }
}
