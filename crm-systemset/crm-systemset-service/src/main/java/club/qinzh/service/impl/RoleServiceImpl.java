package club.qinzh.service.impl;

import club.qinzh.bean.Role;
import club.qinzh.bean.RoleExample;
import club.qinzh.enums.ExceptionEnums;
import club.qinzh.exception.CrmException;
import club.qinzh.mapper.RoleMapper;
import club.qinzh.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Atuhor: qin
 * @Create: 2020-03-09-16-32
 * @Time: 16:32
 * @Description:
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    public Role findById(Long id){
        if(id == null){
            throw new CrmException(ExceptionEnums.PARAM_IS_NULL);
        }
        return roleMapper.selectByPrimaryKey(id);
    }

    public List<Role> findAllRole(){
        return roleMapper.selectByExample(new RoleExample());
    }

    /*public void addRole(Role role){
        roleMapper.insert(role);
    }
    public void updateRole(Role role){
        roleMapper.updateByPrimaryKey(role);
    }*/
    public void saveOrUpadte(Role role){
        if(role == null){
            throw  new CrmException(ExceptionEnums.PARAM_IS_NULL);
        }
        if(role.getRoleId() ==null){
            roleMapper.insert(role);
        }else{
            roleMapper.updateByPrimaryKey(role);
        }
    }

    public void deleteById(Long id){
        if(id == null){
            throw new CrmException(ExceptionEnums.PARAM_IS_NULL);
        }
        roleMapper.deleteByPrimaryKey(id);
    }
}
