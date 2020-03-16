package club.qinzh.service.impl;

import club.qinzh.bean.User;
import club.qinzh.bean.UserExample;
import club.qinzh.bean.extend.UserExtend;
import club.qinzh.enums.ExceptionEnums;
import club.qinzh.exception.CrmException;
import club.qinzh.mapper.UserMapper;
import club.qinzh.mapper.extend.UserExtendMapper;
import club.qinzh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Atuhor: qin
 * @Create: 2020-03-12-09-27
 * @Time: 9:27
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserExtendMapper userExtendMapper;

    public User findByNameAndPassword(String username,String password){
        UserExample example = new UserExample();
        example.createCriteria().andUsrNameEqualTo(username)
                .andUsrPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(example);
        if(users != null && users.size()>0){
            return users.get(0);
        }
        return null;
    }

    public User findById(Long id){
        if(id == null){
            throw new CrmException(ExceptionEnums.PARAM_IS_NULL);
        }
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> findAllUser(){
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public List<UserExtend> findAllUserwithRole() {
        return userExtendMapper.selectAllWithOther();
    }

    public void saveOrUpadte(User user){
        if(user == null){
            throw  new CrmException(ExceptionEnums.PARAM_IS_NULL);
        }
        if(user.getUsrId() ==null){
            userMapper.insert(user);
        }else{
            userMapper.updateByPrimaryKey(user);
        }
    }

    public void deleteById(Long id){
        if(id == null){
            throw new CrmException(ExceptionEnums.PARAM_IS_NULL);
        }
        userMapper.deleteByPrimaryKey(id);
    }
}
